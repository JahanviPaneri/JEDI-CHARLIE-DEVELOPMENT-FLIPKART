package com.flipfit.business;

import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymCenter;
import com.flipfit.bean.Role;
import com.flipfit.bean.User;
import com.flipfit.constants.GymStatus;
import com.flipfit.constants.OwnerStatus;
import com.flipfit.dao.GymOwnerDaoImpl;
import com.flipfit.dao.GymOwnerDaoInterface;
import com.flipfit.dao.UserDaoImpl;
import com.flipfit.dao.UserDaoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service implementation for gym owners to manage their account and gym centers.
 */
public class GymOwnerService implements GymOwnerInterface {

    GymOwnerDaoInterface gymOwnerDao = new GymOwnerDaoImpl();
    UserDaoInterface userDao = new UserDaoImpl();

    @Override
    public void registerOwner(String name, String email , String phoneNumber, String password, String panNumber, String accountNumber) {
        try {
            String userId = UUID.randomUUID().toString();
            String ownerId = UUID.randomUUID().toString();

            Role role = new Role();
            role.setRoleName("GymOwner");

            GymOwner owner = new GymOwner();
            owner.setOwnerId(ownerId);
            // Setting new details
            owner.setPanNumber(panNumber);
            owner.setAccountNumber(accountNumber);
            owner.setOwnerStatus(OwnerStatus.valueOf(owner.getOwnerStatus().toString()));
            User user = new User();
            user.setUserId(userId);
            user.setName(name);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setPasswordHash(password);
            user.setRole(role);

            userDao.addUser(user);
            gymOwnerDao.addGymOwner(owner);

            System.out.println("Request for registration sent successfully with ownerId---> " + owner.getOwnerId());
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    @Override
    public void requestGymAddition(GymCenter gym) {
        gym.setGymStatus(GymStatus.PENDING);
        System.out.println("Gym addition request raised for: " + gym.getGymName());
    }

    @Override
    public void requestGymRemoval(String gymId) {
        // Send a request to the system to remove a specific gym center
        System.out.println("Requesting removal for gym ID: " + gymId);
    }

    @Override
    public List<GymCenter> viewMyGyms(String ownerId) {
        GymCenter tempGym=new GymCenter();
        tempGym.setGymId("123");
        tempGym.setGymLocation("Bangalore");
        tempGym.setGymName("Demo Gym");

        List<GymCenter> tempList = new ArrayList<>();
        tempList.add(tempGym);
        return tempList;
    }
}