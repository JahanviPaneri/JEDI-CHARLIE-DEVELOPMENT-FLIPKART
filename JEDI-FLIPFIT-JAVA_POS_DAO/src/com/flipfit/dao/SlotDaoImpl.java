package com.flipfit.dao;

import com.flipfit.bean.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data Access implementation for managing gym workout slots in memory.
 */
public class SlotDaoImpl implements SlotDaoInterface {

    // Storage for workout slots using slotId as the unique key
    private static Map<String, Slot> slotMap = new HashMap<>();

    @Override
    public void addSlot(Slot slot) {
        // Save a new workout timing slot into the system
        slotMap.put(slot.getSlotId(), slot);
    }

    @Override
    public void removeSlot(String slotId) {
        // Delete a workout timing slot from the storage
        slotMap.remove(slotId);
    }

    @Override
    public Slot getSlotById(String slotId) {
        // Find and return a specific slot using its unique ID
        return slotMap.get(slotId);
    }

    @Override
    public void changeAvailableCapacity(String slotId, int newAvailableCapacity) {
        // Update how many spots are left after a booking or cancellation
        Slot slot = slotMap.get(slotId);
        if (slot != null) {
            slot.setAvailableCapacity(newAvailableCapacity);
            System.out.println("DAO: Availability updated for Slot " + slotId);
        }
    }

    @Override
    public void changeTotalCapacity(String slotId, int newTotalCapacity) {
        // Update the maximum number of people allowed in a specific slot
        Slot slot = slotMap.get(slotId);
        if (slot != null) {
            slot.setTotalCapacity(newTotalCapacity);
            System.out.println("DAO: Total Capacity updated for Slot " + slotId);
        }
    }

    @Override
    public List<Slot> getSlotsByGymId(String gymId) {
        // Retrieve all workout timings associated with a specific gym center
        return slotMap.values().stream()
                .filter(slot -> slot.getGymId().equals(gymId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Slot> getAllSlots() {
        // Get a complete list of every workout slot in the entire system
        return new ArrayList<>(slotMap.values());
    }
}