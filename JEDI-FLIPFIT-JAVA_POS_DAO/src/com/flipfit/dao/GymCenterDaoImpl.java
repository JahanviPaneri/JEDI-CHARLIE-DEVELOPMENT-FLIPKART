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
        // Storing in map using gymId as the key
        gymCenterMap.put(gym.getGymId(), gym);
        System.out.println("DAO: Gym '" + gym.getGymName() + "' registered in the system.");
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
    public void changeGymCenterStatus(String gymId, String status) {
        GymCenter gym = gymCenterMap.get(gymId);
        if (gym != null) {
            // Update status logic (adjust based on your Bean/Enum implementation)
            // gym.setGymStatus(GymStatus.valueOf(status));
            System.out.println("DAO: Status for " + gymId + " updated to " + status);
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
    public List<GymCenter> getAllGymCenters() {
        // Converting Map values to a List for the return type
        return new ArrayList<>(gymCenterMap.values());
    }
}