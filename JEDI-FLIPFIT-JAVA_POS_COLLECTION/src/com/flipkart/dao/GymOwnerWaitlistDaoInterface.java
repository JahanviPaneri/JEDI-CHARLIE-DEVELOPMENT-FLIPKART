package com.flipfit.dao;

import com.flipfit.bean.GymOwnerWaitlist;
import java.util.List;

public interface GymOwnerWaitlistDaoInterface {
    /**
     * Adds a gym owner to the waitlist
     */
    void addToWaitlist(GymOwnerWaitlist waitlistEntry);

    /**
     * Retrieves waitlist entry by owner ID
     */
    GymOwnerWaitlist getWaitlistEntryByOwnerId(String ownerId);

    /**
     * Retrieves all pending waitlist entries
     */
    List<GymOwnerWaitlist> getAllPendingEntries();

    /**
     * Removes entry from waitlist
     */
    void removeFromWaitlist(String ownerId);

    /**
     * Check if owner exists in waitlist
     */
    boolean existsInWaitlist(String ownerId);
}
