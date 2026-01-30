package com.flipfit.dao;

import com.flipfit.bean.GymCenter;
import java.util.List;

public interface GymCenterDaoInterface {
    void addGymCenter(GymCenter gym);
    void removeGymCenter(String gymId);
    boolean changeGymCenterStatus(String gymId);
    List<GymCenter> getPendingGyms();
    List<GymCenter> getGymCentersByLocation(String location);
    GymCenter getGymById(String gymId);

    List<GymCenter> getAllApprovedCenters();
}