package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymOwnerWaitlist;
import com.flipfit.constants.GymStatus;
import com.flipfit.dao.GymOwnerWaitlistDaoImpl;
import com.flipfit.dao.GymOwnerDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminInterface {

    private GymOwnerWaitlistDaoImpl waitlistDao = new GymOwnerWaitlistDaoImpl();
    private GymOwnerDaoImpl gymOwnerDao = new GymOwnerDaoImpl();

    @Override
    public void approveGymCenter(String gymId) {
        // Logic: Update gym status to APPROVED in DB
        System.out.println("Admin approved Gym ID: " + gymId);
    }

    @Override
    public void approveGymOwner(String ownerId) {
        // Fetch from waitlist
        GymOwnerWaitlist waitlistEntry = waitlistDao.getWaitlistEntryByOwnerId(ownerId);
        
        if (waitlistEntry == null) {
            System.out.println("Gym Owner not found in waitlist: " + ownerId);
            return;
        }

        // Create new entry in gym_owner table with same information
        GymOwner approvedOwner = new GymOwner();
        approvedOwner.setOwnerId(ownerId);
        approvedOwner.setEmail(waitlistEntry.getEmail());
        approvedOwner.setPasswordHash(waitlistEntry.getPassword());
        approvedOwner.setAccountNumber(waitlistEntry.getAccountNumber());
        approvedOwner.setPanNumber(waitlistEntry.getPanNumber());

        // Save to gym_owner table
        gymOwnerDao.addGymOwner(approvedOwner);

        // Remove from waitlist
        waitlistDao.removeFromWaitlist(ownerId);

        System.out.println("Admin approved Owner ID: " + ownerId);
        System.out.println("Owner moved to gym_owner table successfully.");
    }

    @Override
    public List<GymCenter> viewPendingGyms() {
        // DAO: Fetch all gyms where status == PENDING
        GymCenter tempGym=new GymCenter();
        tempGym.setGymId("123");
        tempGym.setGymLocation("Bangalore");
        tempGym.setGymName("Demo Gym");
        List<GymCenter> tempList=new ArrayList<>();
        tempList.add(tempGym);
        return tempList;
    }

    @Override
    public List<GymOwner> viewPendingOwners() {
        // This now returns an empty list since we use waitlist
        // Admin should use viewPendingWaitlistEntries() instead
        return new ArrayList<>();
    }

    /**
     * Fetch all pending gym owner registrations from gym_owner_waitlist table
     */
    public List<GymOwnerWaitlist> viewPendingWaitlistEntries() {
        // TODO: Execute: SELECT * FROM gym_owner_waitlist
        return waitlistDao.getAllPendingEntries();
    }
}