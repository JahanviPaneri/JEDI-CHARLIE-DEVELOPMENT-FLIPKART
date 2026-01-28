package com.flipfit.business;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymOwnerWaitlist;
import com.flipfit.bean.GymCenter;
import com.flipfit.bean.Role;
import com.flipfit.constants.GymStatus;
import com.flipfit.dao.GymOwnerWaitlistDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GymOwnerService implements GymOwnerInterface {

    private GymOwnerWaitlistDaoImpl waitlistDao = new GymOwnerWaitlistDaoImpl();

    @Override
    public void registerOwner(String email, String password, String accountNumber, String panNumber) {
        // Create a new waitlist entry with ownerId
        String ownerId = UUID.randomUUID().toString();
        
        GymOwnerWaitlist waitlistEntry = new GymOwnerWaitlist();
        waitlistEntry.setOwnerId(ownerId);
        waitlistEntry.setEmail(email);
        waitlistEntry.setPassword(password);  // In production, hash this password
        waitlistEntry.setAccountNumber(accountNumber);
        waitlistEntry.setPanNumber(panNumber);

        // Save to gym_owner_waitlist table
        waitlistDao.addToWaitlist(waitlistEntry);

        System.out.println("Gym Owner registration request submitted successfully!");
        System.out.println("Your request ID is: " + ownerId);
        System.out.println("Your request is pending admin approval.");
    }

    @Override
    public void requestGymAddition(GymCenter gym) {
        // Logic: Set status to PENDING
        gym.setGymStatus(GymStatus.PENDING);
        // DAO: Save gym request
        System.out.println("Gym addition request raised for: " + gym.getGymName());
    }

    @Override
    public void requestGymRemoval(String gymId) {
        System.out.println("Requesting removal for gym: " + gymId);
    }

    @Override
    public List<GymCenter> viewMyGyms(String ownerId) {
        // DAO: select * where ownerId = ...
        GymCenter tempGym=new GymCenter();
        tempGym.setGymId("123");
        tempGym.setGymLocation("Bangalore");
        tempGym.setGymName("Demo Gym");
        List<GymCenter> tempList=new ArrayList<>();
        tempList.add(tempGym);
        return tempList;
    }
}