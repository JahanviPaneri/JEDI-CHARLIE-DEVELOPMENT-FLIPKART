package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymCenter;
import java.util.List;

public interface GymOwnerDaoInterface {
    /**
     * Registers a new Gym Owner in the system
     */
    void addGymOwner(GymOwner owner);

    boolean updateOwnerStatusToApproved(String ownerId);

    /**
     * Retrieves an owner by their unique ID
     */
    GymOwner getOwnerById(String ownerId);

    /**
     * Retrieves an owner by email for login/verification
     */
    GymOwner getOwnerByEmail(String email);

    /**
     * Returns a list of all owners (useful for Admin views)
     */
    List<GymOwner> getAllOwners();

    /**
     * Removes an owner from the system
     */
    void deleteOwner(String ownerId);

    List<GymOwner> getPendingOwners();
    
    /**
     * Retrieves a list of gyms owned by a specific owner.
     */

    List<GymCenter> getGymsByOwnerEmail(String email);
}