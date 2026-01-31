package com.flipfit.business;

import com.flipfit.bean.Waitlist;
import java.util.List;

/**
 * Interface for managing users waiting for a spot in a full gym slot.
 */
public interface WaitlistInterface {

    // Add a user to the waiting list when a gym slot is full
    void addToWaitlist(String userId, String slotId);

    // Move the next person from the waiting list to an active booking
    void promoteUserFromWaitlist(String slotId);

    // Manually delete a specific entry from the waiting list
    void removeWaitlistEntry(String waitlistId);

    // Show all users currently waiting for a specific gym time slot
    List<Waitlist> getWaitlistBySlot(String slotId);
}