package com.flipkart.dao;

import com.flipkart.bean.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SlotDaoImpl implements SlotDaoInterface {

    private static Map<String, Slot> slotMap = new HashMap<>();

    @Override
    public void addSlot(Slot slot) {
        slotMap.put(slot.getSlotId(), slot);
    }

    @Override
    public void removeSlot(String slotId) {
        slotMap.remove(slotId);
    }

    @Override
    public Slot getSlotById(String slotId) {
        return slotMap.get(slotId);
    }

    /**
     * Used by the BookingService when a user books or cancels a spot.
     */
    @Override
    public void changeAvailableCapacity(String slotId, int newAvailableCapacity) {
        Slot slot = slotMap.get(slotId);
        if (slot != null) {
            slot.setAvailableCapacity(newAvailableCapacity);
            System.out.println("DAO: Availability updated for Slot " + slotId);
        }
    }

    /**
     * Used by the GymOwner to change the overall limit of the slot.
     */
    @Override
    public void changeTotalCapacity(String slotId, int newTotalCapacity) {
        Slot slot = slotMap.get(slotId);
        if (slot != null) {
            slot.setTotalCapacity(newTotalCapacity);
            System.out.println("DAO: Total Capacity updated for Slot " + slotId);
        }
    }

    @Override
    public List<Slot> getSlotsByGymId(String gymId) {
        return slotMap.values().stream()
                .filter(slot -> slot.getGymId().equals(gymId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Slot> getAllSlots() {
        return new ArrayList<>(slotMap.values());
    }
}