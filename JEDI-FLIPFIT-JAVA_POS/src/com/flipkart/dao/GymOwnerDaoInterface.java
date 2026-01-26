package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import java.util.List;

public interface GymOwnerDaoInterface {
    /**
     * Registers a new Gym Owner in the system
     */
    void addGymOwner(GymOwner owner);

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
}