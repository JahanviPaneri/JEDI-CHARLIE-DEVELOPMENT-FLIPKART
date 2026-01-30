package com.Flipfit.dao;


import com.Flipfit.bean.Admin;
import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;

import java.util.List;

public interface AdminDaoInterface {
    void addAdmin(Admin admin);
    void approveGymCenter(String gymId);
    void approveGymOwner(String ownerId);
    List<GymCenter> viewPendingGyms();
    List<GymOwner> viewPendingOwners();
}