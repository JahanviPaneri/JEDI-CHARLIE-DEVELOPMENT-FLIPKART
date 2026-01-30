package com.flipfit.dao;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.constant.SQLConstants;
import com.flipfit.constants.GymStatus;
import com.flipfit.constants.OwnerStatus;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GymOwnerDaoImpl implements GymOwnerDaoInterface {

    // Key: ownerId, Value: GymOwner Object
    private static final Map<String, GymOwner> ownerMap = new HashMap<>();

    @Override
    public void addGymOwner(GymOwner owner) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.INSERT_GYM_OWNER)) {

            // Mapping GymOwner bean fields to SQL query parameters
            pstmt.setString(1, owner.getOwnerId());
            pstmt.setString(2, owner.getPanNumber());
            pstmt.setString(3, owner.getAccountNumber());
            pstmt.setString(4, String.valueOf(owner.getOwnerStatus()));
            pstmt.executeUpdate();
            System.out.println("DAO: Gym Owner registered in DB with status PENDING: " + owner.getOwnerId());

        } catch (SQLException e) {
            System.err.println("Error registering gym owner: " + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public boolean updateOwnerStatusToApproved(String ownerId) {
        // We use the constant here instead of a hardcoded string
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQLConstants.APPROVE_GYM_OWNER_QUERY)) {

            statement.setString(1, ownerId);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return false;
        }
    }
    @Override
    public GymOwner getOwnerById(String ownerId) {
        return ownerMap.get(ownerId);
    }

    @Override
    public GymOwner getOwnerByEmail(String email) {
        GymOwner owner = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_GYM_OWNER_BY_EMAIL)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                owner = new GymOwner();
                owner.setOwnerId(rs.getString("ownerId"));
                owner.setPanNumber(rs.getString("panNumber"));
                owner.setAccountNumber(rs.getString("accountNumber"));
                owner.setOwnerStatus(OwnerStatus.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching Gym Owner by email: " + e.getMessage());
        }
        return owner;
    }

    @Override
    public List<GymOwner> getAllOwners() {
        return new ArrayList<>(ownerMap.values());
    }

    @Override
    public void deleteOwner(String ownerId) {
        if (ownerMap.containsKey(ownerId)) {
            ownerMap.remove(ownerId);
            System.out.println("DAO: Gym Owner " + ownerId + " removed.");
        }
    }

    @Override
    public List<GymOwner> getPendingOwners() {
        List<GymOwner> pendingOwners = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQLConstants.SELECT_PENDING_GYM_OWNERS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GymOwner owner = new GymOwner();
                owner.setOwnerId(rs.getString("ownerId"));
                owner.setAccountNumber(rs.getString("accountNumber"));
                owner.setPanNumber(rs.getString("panNumber"));
                owner.setOwnerStatus(OwnerStatus.PENDING);
                pendingOwners.add(owner);
            }
        } catch (Exception e) {
            System.out.println("Error fetching pending gym owners: " + e.getMessage());
        }
        return pendingOwners;
    }

    @Override
    public List<GymCenter> getGymsByOwnerEmail(String email) {
        List<GymCenter> gyms = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.GET_GYMS_BY_OWNER_EMAIL)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                GymCenter gym = new GymCenter();
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setGymLocation(rs.getString("gymLocation"));
                String statusFromDB = rs.getString("gymStatus");
                if (statusFromDB != null) {
                    gym.setGymStatus(GymStatus.valueOf(statusFromDB.toUpperCase()));
                }
                gym.setGymOwnerId(rs.getString("gymOwnerId"));
                gyms.add(gym);
            }
        } catch (SQLException e) {
            System.err.println("DAO Error: Could not fetch gyms for email " + email + " - " + e.getMessage());
        }
        return gyms;
    }
}