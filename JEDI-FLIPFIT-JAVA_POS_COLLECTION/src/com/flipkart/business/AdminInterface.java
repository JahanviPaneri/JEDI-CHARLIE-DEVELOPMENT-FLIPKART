package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import java.util.List;

public interface AdminInterface {
    void approveGymCenter(String gymId);
    void approveGymOwner(String ownerId);
    List<GymCenter> viewPendingGyms();
    List<GymOwner> viewPendingOwners();
}