package com.Flipfit.buisness;

import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;
import com.Flipfit.bean.Role;
import com.Flipfit.constants.GymStatus;
import com.Flipfit.dao.GymOwnerDaoImpl;
import com.Flipfit.dao.GymOwnerDaoInterface;

import java.util.List;
import java.util.UUID;

public class GymOwnerService implements GymOwnerInterface {
    private GymOwnerDaoInterface gymOwnerDao = new GymOwnerDaoImpl();

    @Override
    public void registerOwner(String name, String email, String phoneNumber, String password) {
        GymOwner owner = new GymOwner();
        owner.setUserId(UUID.randomUUID().toString());
        owner.setOwnerId(UUID.randomUUID().toString());
        owner.setName(name);
        owner.setEmail(email);
        owner.setPhoneNumber(phoneNumber);
        owner.setPasswordHash(password);

        Role role = new Role();
        role.setRoleName("GymOwner");
        owner.setRole(String.valueOf(role));

        gymOwnerDao.addGymOwner(owner);
        System.out.println("Request for registration sent successfully with ownerId---> " + owner.getOwnerId());
    }

    @Override
    public void requestGymAddition(GymCenter gym) {
        gym.setGymStatus(GymStatus.PENDING);
        gymOwnerDao.requestGymAddition(gym);
        System.out.println("Gym addition request raised for: " + gym.getGymName());
    }

    @Override
    public void requestGymRemoval(String gymId) {
        gymOwnerDao.requestGymRemoval(gymId);
        System.out.println("Requesting removal for gym: " + gymId);
    }

    @Override
    public List<GymCenter> viewMyGyms(String ownerId) {
        return gymOwnerDao.viewMyGyms(ownerId);
    }
}