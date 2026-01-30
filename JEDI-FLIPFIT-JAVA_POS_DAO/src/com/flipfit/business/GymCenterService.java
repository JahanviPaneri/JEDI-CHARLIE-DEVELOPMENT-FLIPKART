package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.Slot;
import com.flipfit.dao.GymCenterDaoImpl;
import com.flipfit.dao.GymCenterDaoInterface;
import com.flipfit.dao.SlotDaoImpl;
import com.flipfit.dao.SlotDaoInterface;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Service implementation for managing gym facilities and their workout schedules.
 */
public class GymCenterService implements GymCenterInterface {
    Scanner scanner = new Scanner(System.in);
    GymOwnerService ownerService = new GymOwnerService();
    GymCenterDaoInterface gymCenterDao = new GymCenterDaoImpl();
    @Override
    public void registerGym(String ownerId, String gymName, String gymLocation) {
        String gymId = UUID.randomUUID().toString();

        GymCenter gym = new GymCenter();
        gym.setGymId(gymId);
        gym.setGymName(gymName);
        gym.setGymLocation(gymLocation);
        gym.setGymOwnerId(ownerId);
        gymCenterDao.addGymCenter(gym);
        ownerService.requestGymAddition(gym);
    }
    @Override
    public void addSlot(String gymId, Slot slot) {
        // Create a new time slot for workouts at a specific gym center
        System.out.println("Adding slot to gym ID: " + gymId);
    }

    @Override
    public void removeSlot(String slotId) {
        // Delete a time slot from the system if it's no longer needed
        System.out.println("Removing slot ID: " + slotId);
    }

    private GymCenterDaoInterface gymCenterDAO = new GymCenterDaoImpl();

    @Override
    public List<GymCenter> viewAllCenters() {
        // Business Logic: Retrieve only verified/approved centers
        List<GymCenter> approvedCenters = gymCenterDAO.getAllApprovedCenters();

        if (approvedCenters.isEmpty()) {
            System.out.println("Notice: No approved gym centers found in the system.");
        }

        return approvedCenters;
    }

    private SlotDaoInterface slotDAO = new SlotDaoImpl();

    @Override
    public Slot getAvailableSlots(String gymId) {
        // 1. Try to find the slot in the database
        Slot existingSlot = slotDAO.getSlotByDetails(gymId);

        // 2. Logic: If not present in table, mark it as available/create default
        if (existingSlot == null) {
            Slot defaultSlot = new Slot();
            defaultSlot.setSlotId("N/A"); // Indicates it's not a DB record yet

            // Default capacities for a new/untracked slot
            defaultSlot.setTotalCapacity(100);
            defaultSlot.setAvailableCapacity(100);

            return defaultSlot;
        }

        return existingSlot;
    }

    @Override
    public void updateGymDetails(GymCenter gym) {
        // Modify gym information like its name, location, or total capacity
        System.out.println("Updating details for: " + gym.getGymName());
    }
}