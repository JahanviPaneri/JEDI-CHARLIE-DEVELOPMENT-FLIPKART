package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import java.util.List;

public interface GymCenterDaoInterface {
    void addGymCenter(GymCenter gym);
    void removeGymCenter(String gymId);
    void changeGymCenterStatus(String gymId, String status);
    List<GymCenter> getPendingGyms();
    List<GymCenter> getGymCentersByLocation(String location);
    GymCenter getGymById(String gymId);
    List<GymCenter> getAllGymCenters();
}