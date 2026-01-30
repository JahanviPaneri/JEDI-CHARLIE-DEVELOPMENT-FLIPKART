package com.Flipfit.dao;

import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;

import java.util.List;

public interface GymOwnerDaoInterface {
    void addGymOwner(GymOwner owner);
    void requestGymAddition(GymCenter gym);
    void requestGymRemoval(String gymId);
    List<GymCenter> viewMyGyms(String ownerId);
}