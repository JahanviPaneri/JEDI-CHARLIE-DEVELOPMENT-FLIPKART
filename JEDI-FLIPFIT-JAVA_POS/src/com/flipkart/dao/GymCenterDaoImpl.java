package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.constants.GymStatus; // Assuming you have an Enum for status
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        // Filtering values from the map
        return gymCenterMap.values().stream()
                .filter(gym -> "PENDING".equalsIgnoreCase(gym.getGymStatus().toString()))
                .collect(Collectors.toList());
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