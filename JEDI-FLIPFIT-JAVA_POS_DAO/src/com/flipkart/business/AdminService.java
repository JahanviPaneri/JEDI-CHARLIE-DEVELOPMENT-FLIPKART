package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.GymStatus;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminInterface {

    @Override
    public void approveGymCenter(String gymId) {
        // Logic: Update gym status to APPROVED in DB
        System.out.println("Admin approved Gym ID: " + gymId);
    }

    @Override
    public void approveGymOwner(String ownerId) {
        // Logic: Update owner status to APPROVED
        System.out.println("Admin approved Owner ID: " + ownerId);
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

        GymOwner owner = new GymOwner();
        owner.setOwnerId("1234");
        owner.setName("Demo owner");
        List<GymOwner> ownerList=new ArrayList<>();
        ownerList.add(owner);
        return ownerList;
    }
}