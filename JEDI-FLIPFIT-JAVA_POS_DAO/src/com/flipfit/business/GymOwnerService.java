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
    public List<GymCenter> viewMyGyms(String email) {
        System.out.println("Fetching gyms for email: " + email);
        GymOwner owner = gymOwnerDao.getOwnerByEmail(email);
        if (owner == null) {
            System.out.println("No Gym Owner found for email: " + email);
            return new ArrayList<>();
        }
        String ownerId = owner.getOwnerId();
        System.out.println("Fetching gyms for ownerId: " + ownerId);
        List<GymCenter> gyms = gymOwnerDao.getGymsByOwnerId(ownerId);
        if (gyms.isEmpty()) {
            System.out.println("No gyms found for ownerId: " + ownerId);
        } else {
            System.out.println("Gyms found for ownerId: " + ownerId);
            for (GymCenter gym : gyms) {
                System.out.println("Gym ID: " + gym.getGymId() + ", Name: " + gym.getGymName() + ", Location: " + gym.getGymLocation() + ", Capacity: " + gym.getCapacity() + ", Status: " + gym.getGymStatus());
            }
        }
        return gyms;
    }
}