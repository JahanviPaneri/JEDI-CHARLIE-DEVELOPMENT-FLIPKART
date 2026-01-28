package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.Slot;
import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for managing gym facilities and their workout schedules.
 */
public class GymCenterService implements GymCenterInterface {

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

    @Override
    public List<GymCenter> viewAllCenters() {
        // Retrieve all gym centers that have been verified and approved by the admin
        GymCenter tempGym = new GymCenter();
        tempGym.setGymId("123");
        tempGym.setGymLocation("Bangalore");
        tempGym.setGymName("Demo Gym");
        List<GymCenter> tempList = new ArrayList<>();
        tempList.add(tempGym);
        return tempList;
    }

    @Override
    public List<Slot> getAvailableSlots(String gymId) {
        // Get all workout timings that still have open spaces for customers
        Slot slot = new Slot();
        slot.setSlotId("321");
        slot.setAvailableCapacity(120);
        slot.setTotalCapacity(200);
        slot.setStartTime("8 AM");
        slot.setDate("30-1-2026");
        List<Slot> slotList = new ArrayList<>();
        slotList.add(slot);
        return slotList;
    }

    @Override
    public void updateGymDetails(GymCenter gym) {
        // Modify gym information like its name, location, or total capacity
        System.out.println("Updating details for: " + gym.getGymName());
    }
}