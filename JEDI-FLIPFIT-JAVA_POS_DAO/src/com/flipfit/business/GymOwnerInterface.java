package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import java.util.List;

/**
 * Interface for gym owners to manage their profile and gym centers.
 */
public interface GymOwnerInterface {
    void registerOwner(String name, String email , String phoneNumber, String password, String panNumber, String aadharNumber);
    void requestGymAddition(GymCenter gym);

    // Submit a request to delete a gym center from the platform
    void requestGymRemoval(String gymId);

    // Get a list of all gym centers belonging to a specific owner
    List<GymCenter> viewMyGyms(String ownerId);
}