package com.flipfit.dao;

import com.flipfit.bean.GymCenter;
import java.util.List;

/**
 * Interface for database operations related to gym centers.
 */
public interface GymCenterDaoInterface {

    // Save a new gym center record into the database
    void addGymCenter(GymCenter gym);

    // Remove a gym center from the system using its unique ID
    void removeGymCenter(String gymId);

    // Update the verification status (e.g., PENDING or APPROVED) of a gym
    void changeGymCenterStatus(String gymId, String status);

    // Get a list of all gym centers that are currently waiting for admin approval
    List<GymCenter> getPendingGyms();

    // Search and return gym centers located in a specific area or city
    List<GymCenter> getGymCentersByLocation(String location);

    // Retrieve the full details of a specific gym using its ID
    GymCenter getGymById(String gymId);

    // Retrieve a complete list of every gym center registered in the system
    List<GymCenter> getAllGymCenters();
}