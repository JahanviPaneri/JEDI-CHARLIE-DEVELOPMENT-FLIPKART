package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import java.util.List;

/**
 * Interface for Admin operations like registration and approvals.
 */
public interface AdminInterface {
    void registerAdmin(String name, String email, String phoneNumber, String password, String aadharNumber, String panNumber);
    void approveGymCenter(String gymId);

    // Verify and allow a gym owner to use the platform
    void approveGymOwner(String ownerId);

    // Get a list of all gyms waiting for admin permission
    List<GymCenter> viewPendingGyms();

    // Get a list of all owners waiting for admin permission
    List<GymOwner> viewPendingOwners();
}