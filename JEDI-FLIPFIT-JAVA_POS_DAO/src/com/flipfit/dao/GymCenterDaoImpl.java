package com.flipfit.dao;


import com.flipfit.bean.GymCenter;
import com.flipfit.constant.SQLConstants;
import com.flipfit.constants.GymStatus;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.sql.ResultSet;


public class GymCenterDaoImpl implements GymCenterDaoInterface {

    // Using Map for O(1) lookups: Key = gymId, Value = GymCenter Object
    private static Map<String, GymCenter> gymCenterMap = new HashMap<>();

    @Override
    public void addGymCenter(GymCenter gym) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.INSERT_GYM_CENTER)) {

            // Mapping GymOwner bean fields to SQL query parameters
            pstmt.setString(1, gym.getGymId());
            pstmt.setString(2, gym.getGymName());
            pstmt.setString(3, gym.getGymLocation());
            pstmt.setString(4, "PENDING");
            pstmt.setString(5, gym.getGymOwnerId());
            pstmt.executeUpdate();
            System.out.println("DAO: Gym Owner registered in DB with status PENDING: " + gym.getGymId());

        } catch (SQLException e) {
            System.err.println("Error registering gym owner: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeGymCenter(String gymId) {
        if (gymCenterMap.containsKey(gymId)) {
            gymCenterMap.remove(gymId);
            System.out.println("DAO: Gym ID " + gymId + " successfully removed.");
        } else {
            System.out.println("DAO: Gym ID " + gymId + " not found.");
        }
    }

    @Override
    public boolean changeGymCenterStatus(String gymId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SQLConstants.UPDATE_GYM_CENTER_STATUS)) {

            statement.setString(1, gymId);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public GymCenter getGymById(String gymId) {
        return gymCenterMap.get(gymId);
    }

    @Override
    public List<GymCenter> getPendingGyms() {
        List<GymCenter> pendingGyms = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQLConstants.SELECT_PENDING_GYM_CENTERS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GymCenter gym = new GymCenter();
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setGymLocation(rs.getString("gymLocation"));
                gym.setGymOwnerId(rs.getString("gymOwnerId"));
                gym.setGymStatus(GymStatus.PENDING);
                pendingGyms.add(gym);
            }
        } catch (Exception e) {
            System.out.println("Error fetching pending gyms: " + e.getMessage());
        }
        return pendingGyms;
    }

    @Override
    public List<GymCenter> getGymCentersByLocation(String location) {
        return gymCenterMap.values().stream()
                .filter(gym -> gym.getGymLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    @Override
    public List<GymCenter> getAllApprovedCenters() {
        List<GymCenter> centers = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQLConstants.SELECT_APPROVED_CENTERS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                GymCenter gym = new GymCenter();
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setGymLocation(rs.getString("gymLocation"));
                centers.add(gym);
            }
        } catch (SQLException e) {
            System.err.println("DAO Error: " + e.getMessage());
        }
        return centers;
    }
}