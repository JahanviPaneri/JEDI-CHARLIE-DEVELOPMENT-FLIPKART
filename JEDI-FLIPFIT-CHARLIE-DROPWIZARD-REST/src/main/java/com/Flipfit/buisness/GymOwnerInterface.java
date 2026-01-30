package com.Flipfit.buisness;

import com.Flipfit.bean.GymCenter;

import java.util.List;

public interface GymOwnerInterface {
    void registerOwner(String name, String email, String phoneNumber, String password);
    void requestGymAddition(GymCenter gym);
    void requestGymRemoval(String gymId);
    List<GymCenter> viewMyGyms(String ownerId);
}