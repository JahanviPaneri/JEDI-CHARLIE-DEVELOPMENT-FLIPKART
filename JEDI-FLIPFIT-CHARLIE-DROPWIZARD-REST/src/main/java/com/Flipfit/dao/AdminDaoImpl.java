package com.Flipfit.dao;

import com.Flipfit.bean.Admin;
import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDaoInterface {
    @Override
    public void addAdmin(Admin admin) {
        // SQL Logic: INSERT INTO Admin (adminId, name, email...) VALUES (?, ?, ?);
        System.out.println("DAO: Admin added to database: " + admin.getName());
    }

    @Override
    public void approveGymCenter(String gymId) {
        // SQL Logic: UPDATE Gym SET status = 'APPROVED' WHERE gymId = ?;
        System.out.println("DAO: Gym " + gymId + " status updated to APPROVED");
    }

    @Override
    public void approveGymOwner(String ownerId) {
        // SQL Logic: UPDATE GymOwner SET isApproved = true WHERE ownerId = ?;
        System.out.println("DAO: Owner " + ownerId + " status updated to APPROVED");
    }

    @Override
    public List<GymCenter> viewPendingGyms() {
        // SQL Logic: SELECT * FROM Gym WHERE status = 'PENDING';
        List<GymCenter> pendingGyms = new ArrayList<>();
        return pendingGyms;
    }

    @Override
    public List<GymOwner> viewPendingOwners() {
        // SQL Logic: SELECT * FROM GymOwner WHERE isApproved = false;
        List<GymOwner> pendingOwners = new ArrayList<>();
        return pendingOwners;
    }
}