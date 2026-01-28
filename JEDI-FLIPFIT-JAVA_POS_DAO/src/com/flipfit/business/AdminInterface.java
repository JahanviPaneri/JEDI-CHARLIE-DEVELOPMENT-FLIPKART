package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.constants.*;
import java.util.List;

/**
 * Interface for Admin operations like registration and approvals.
 */
public interface AdminInterface {

    // Register a new admin into the system
    void registerAdmin(String name, String email, String phoneNumber, String password);

    // Verify and allow a gym center to start its business
    void approveGymCenter(String gymId);

    // Verify and allow a gym owner to use the platform
    void approveGymOwner(String ownerId);

    // Get a list of all gyms waiting for admin permission
    List<GymCenter> viewPendingGyms();

    // Get a list of all owners waiting for admin permission
    List<GymOwner> viewPendingOwners();

    /**
     * Filters gym centers based on their approval status (APPROVED, PENDING, REJECTED).
     * @param status The status to filter by.
     * @return List of GymCenters matching the status.
     */
    List<GymCenter> filterGymCentersByStatus(GymStatus status);

    /**
     * Filters gym owners based on their approval status (APPROVED, PENDING, REJECTED).
     * @param status The status to filter by.
     * @return List of GymOwners matching the status.
     */
    List<GymOwner> filterGymOwnersByStatus(GymStatus status);
}