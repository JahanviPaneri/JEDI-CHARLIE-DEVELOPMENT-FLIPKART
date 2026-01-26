package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCenter;
import java.util.List;

public interface GymOwnerServiceInterface {
    // Owner Profile
    void registerOwner(GymOwner owner);
    void login(String email, String password);

    // Gym Management Requests
    void requestGymAddition(GymCenter gym);
    void requestGymRemoval(String gymId);

    // View data
    List<GymCenter> viewMyGyms(String ownerId);
}