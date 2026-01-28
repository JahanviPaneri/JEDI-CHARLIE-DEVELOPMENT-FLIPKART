package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import java.util.List;

public interface AdminInterface {
    void registerAdmin(String name, String email, String phoneNumber, String password);
    void approveGymCenter(String gymId);
    void approveGymOwner(String ownerId);
    List<GymCenter> viewPendingGyms();
    List<GymOwner> viewPendingOwners();
}