package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Role;
import com.flipkart.constants.GymStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GymOwnerService implements GymOwnerInterface {

    @Override
    public void registerOwner(String name, String email , String phoneNumber, String password) {
        // Logic: Save owner details via DAO

        GymOwner owner=new GymOwner();
        owner.setUserId(UUID.randomUUID().toString());
        owner.setOwnerId(UUID.randomUUID().toString());
        owner.setName(name);
        owner.setEmail(email);
        owner.setPhoneNumber(phoneNumber);
        //create hash of password and save hash
        owner.setPasswordHash(password);


        Role role =new Role();
        //set role id and role des and role name
        role.setRoleName("GymOwner");
        owner.setRole(role);



        // send the request to admin => pending

        System.out.println("Request for registration sent successfully with ownerId---> " + owner.getOwnerId());
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