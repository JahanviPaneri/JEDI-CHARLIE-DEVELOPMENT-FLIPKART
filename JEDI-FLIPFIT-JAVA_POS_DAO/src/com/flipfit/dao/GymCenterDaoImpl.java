package com.flipfit.dao;

import com.flipfit.bean.GymCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data Access implementation for managing gym centers in memory.
 */
public class GymCenterDaoImpl implements GymCenterDaoInterface {

    // Storage for all gym centers using gymId as the unique key
    private static Map<String, GymCenter> gymCenterMap = new HashMap<>();

    @Override
    public void addGymCenter(GymCenter gym) {
        // Save a new gym center record into the map
        gymCenterMap.put(gym.getGymId(), gym);
        System.out.println("DAO: Gym '" + gym.getGymName() + "' registered in the system.");
    }

    @Override
    public void removeGymCenter(String gymId) {
        // Delete a gym center from the map using its ID
        if (gymCenterMap.containsKey(gymId)) {
            gymCenterMap.remove(gymId);
            System.out.println("DAO: Gym ID " + gymId + " successfully removed.");
        }
    }

    @Override
    public void changeGymCenterStatus(String gymId, String status) {
        // Update the approval status (e.g., PENDING to APPROVED) for a gym
        GymCenter gym = gymCenterMap.get(gymId);
        if (gym != null) {
            System.out.println("DAO: Status for " + gymId + " updated to " + status);
        }
    }

    @Override
    public GymCenter getGymById(String gymId) {
        // Find and return a specific gym center using its ID
        return gymCenterMap.get(gymId);
    }

    @Override
    public List<GymCenter> getPendingGyms() {
        // Filter the list to find gyms waiting for admin approval
        return gymCenterMap.values().stream()
                .filter(gym -> "PENDING".equalsIgnoreCase(gym.getGymStatus().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public List<GymCenter> getGymCentersByLocation(String location) {
        // Search for gym centers located in a specific city or area
        return gymCenterMap.values().stream()
                .filter(gym -> gym.getGymLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    @Override
    public List<GymCenter> getAllGymCenters() {
        // Retrieve a full list of every gym center in the system
        return new ArrayList<>(gymCenterMap.values());
    }
}