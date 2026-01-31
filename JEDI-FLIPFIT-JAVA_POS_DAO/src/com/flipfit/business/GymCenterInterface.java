package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.Slot;
import java.util.List;

/**
 * Interface for managing gym centers and their time slots.
 */
public interface GymCenterInterface {

    // Add a new workout time slot to a specific gym center
    void addSlot(String gymId, Slot slot);

    // Delete an existing time slot from the system
    void removeSlot(String slotId);

    // Show a list of all gym centers registered on the platform
    List<GymCenter> viewAllCenters();

    // Get all slots that are currently open for booking at a specific gym
    List<Slot> getAvailableSlots(String gymId);

    // Update information like name, location, or capacity for a gym
    void updateGymDetails(GymCenter gym);
}