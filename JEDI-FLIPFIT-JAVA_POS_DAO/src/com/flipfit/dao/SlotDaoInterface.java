package com.flipfit.dao;

import com.flipfit.bean.Slot;
import java.util.List;

/**
 * Interface for database operations related to workout time slots.
 */
public interface SlotDaoInterface {

    // Save a new workout time slot into the database
    void addSlot(Slot slot);

    // Delete a specific time slot using its unique ID
    void removeSlot(String slotId);

    // Retrieve the full details of a specific slot by its ID
    Slot getSlotById(String slotId);

    // Get all time slots belonging to a particular gym center
    List<Slot> getSlotsByGymId(String gymId);

    // Update the number of remaining spots after a booking or cancellation
    void changeAvailableCapacity(String slotId, int newAvailableCapacity);

    // Update the maximum allowed capacity for a specific workout session
    void changeTotalCapacity(String slotId, int newTotalCapacity);

    // Retrieve a complete list of every workout slot in the system
    List<Slot> getAllSlots();
}