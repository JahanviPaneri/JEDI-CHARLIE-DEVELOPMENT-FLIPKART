package com.flipfit.dao;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.constant.SQLConstants;
import com.flipfit.constants.OwnerStatus;
import com.flipfit.utils.DBConnection;

import com.flipfit.constant.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GymOwnerDaoImpl implements GymOwnerDaoInterface {

    // Key: ownerId, Value: GymOwner Object
    private static final Map<String, GymOwner> ownerMap = new HashMap<>();

    @Override
    public void addGymOwner(GymOwner owner) {
        ownerMap.put(owner.getOwnerId(), owner);
        System.out.println("DAO: Gym Owner registered: " + owner.getOwnerId());
    }

    @Override
    public GymOwner getOwnerById(String ownerId) {
        return ownerMap.get(ownerId);
    }

    @Override
    public GymOwner getOwnerByEmail(String email) {
        return ownerMap.values().stream()
                .filter(owner -> owner.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
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
}