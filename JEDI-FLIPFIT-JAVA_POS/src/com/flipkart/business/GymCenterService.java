package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class GymCenterServiceInterfaceImpl implements GymCenterServiceInterface {
    @Override
    public void addSlot(String gymId, Slot slot) {
        // 1. Logic: Verify if the gym exists
        // 2. Logic: Ensure the slot timing is valid (e.g., startTime < endTime)
        // 3. DAO: gymDao.addSlot(gymId, slot);
        System.out.println("Slot added successfully to Gym: " + gymId);
    }

    @Override
    public void removeSlot(String slotId) {
        // 1. Logic: Check if there are any active bookings for this slot
        // 2. If yes, throw an exception or handle cancellation
        // 3. DAO: gymDao.deleteSlot(slotId);
        System.out.println("Slot " + slotId + " has been removed.");
    }

    @Override
    public List<GymCenter> getAllGymCenters() {
        // Logic: Return only those gyms where status is 'APPROVED'
        System.out.println("Fetching all approved gym centers...");
        return new ArrayList<>();
    }

    @Override
    public List<GymCenter> getGymCentersByCity(String city) {
        // DAO: gymDao.getGymsByCity(city);
        return new ArrayList<>();
    }

    @Override
    public List<Slot> getAvailableSlotsByGym(String gymId) {
        // Logic: Return slots where availableCapacity > 0
        return new ArrayList<>();
    }

    @Override
    public void updateGymStatus(String gymId, String status) {
        // Logic: Used by Admin to change status to APPROVED or REJECTED
        // DAO: gymDao.updateStatus(gymId, status);
        System.out.println("Gym " + gymId + " status updated to: " + status);
    }

}
