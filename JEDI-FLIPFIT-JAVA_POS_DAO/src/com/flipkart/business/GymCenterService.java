package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import java.util.ArrayList;
import java.util.List;

public class GymCenterService implements GymCenterInterface {

    @Override
    public void addSlot(String gymId, Slot slot) {
        // Logic: Validate slot timing overlap
        System.out.println("Adding slot to gym ID: " + gymId);
    }

    @Override
    public void removeSlot(String slotId) {
        // Logic: Check if bookings exist before removing
        System.out.println("Removing slot ID: " + slotId);
    }

    @Override
    public List<GymCenter> viewAllCenters() {
        // Logic: Fetch from DAO where status is APPROVED
        GymCenter tempGym=new GymCenter();
        tempGym.setGymId("123");
        tempGym.setGymLocation("Bangalore");
        tempGym.setGymName("Demo Gym");
        List<GymCenter> tempList=new ArrayList<>();
        tempList.add(tempGym);
        return tempList;
    }

    @Override
    public List<Slot> getAvailableSlots(String gymId) {
        // Logic: Fetch slots for gymId where capacity > 0
        Slot slot=new Slot();
        slot.setSlotId("321");
        slot.setAvailableCapacity(120);
        slot.setTotalCapacity(200);
        slot.setStartTime("8 AM");
        slot.setDate("30-1-2026");
        List<Slot> slotList=new ArrayList<>();
        slotList.add(slot);
        return slotList;
    }

    @Override
    public void updateGymDetails(GymCenter gym) {
        System.out.println("Updating details for: " + gym.getGymName());
    }
}