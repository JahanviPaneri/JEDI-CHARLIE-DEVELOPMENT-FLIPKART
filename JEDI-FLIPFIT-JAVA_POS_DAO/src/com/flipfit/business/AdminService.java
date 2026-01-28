package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.*;
import com.flipfit.constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of Admin operations for the FlipFit system.
 */
public class AdminService implements AdminInterface {

    // --- EXISTING REGISTRATION LOGIC ---
    @Override
    public void registerAdmin(String name, String email, String phoneNumber, String password) {
        String userId = UUID.randomUUID().toString();
        String adminId = UUID.randomUUID().toString();

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");

        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPasswordHash(password);
        user.setRole(adminRole);

        Admin admin = new Admin();
        admin.setUserId(userId);
        admin.setAdminId(adminId);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPhoneNumber(phoneNumber);
        admin.setPasswordHash(password);
        admin.setRole(adminRole);

        UserDaoInterface userDao = new UserDaoImpl();
        userDao.addUser(user);

        AdminDaoInterface adminDao = new AdminDaoImpl();
        adminDao.addAdmin(admin);

        System.out.println("Registration successful for Admin: " + name);
    }

    // --- APPROVAL LOGIC ---
    @Override
    public void approveGymCenter(String gymId) {
        // You can now use the DAO here too if you want to actually update the DB
        GymCenterDaoInterface gymCenterDao = new GymCenterDaoImpl();
        gymCenterDao.changeGymCenterStatus(gymId, GymStatus.APPROVED.toString());
        System.out.println("Admin approved Gym ID: " + gymId);
    }

    @Override
    public void approveGymOwner(String ownerId) {
        // Logic to approve owner would go here
        System.out.println("Admin approved Owner ID: " + ownerId);
    }

    // ------------------------------------------------------------------------
    // FUNCTIONAL PROGRAMMING IMPLEMENTATION (Stream API + DAO)
    // ------------------------------------------------------------------------

    @Override
    public List<GymCenter> filterGymCentersByStatus(GymStatus status) {
        // 1. Initialize the DAO to get data from the "Database" (Map)
        GymCenterDaoInterface gymCenterDao = new GymCenterDaoImpl();

        // 2. Get Source: Fetch the complete list of gyms from the DAO
        List<GymCenter> allCentres = gymCenterDao.getAllGymCenters();

        // 3. Stream & Filter: Use Lambda to match the requested status
        return allCentres.stream()
                .filter(centre -> centre.getGymStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public List<GymOwner> filterGymOwnersByStatus(GymStatus status) {
        // 1. Initialize the DAO to get data from the "Database" (Map)
        GymOwnerDaoInterface gymOwnerDao = new GymOwnerDaoImpl();

        // 2. Get Source: Fetch the complete list of owners from the DAO
        List<GymOwner> allOwners = gymOwnerDao.getAllOwners();

        // 3. Stream & Filter: Use Lambda to match the requested status
        return allOwners.stream()
                .filter(owner -> owner.getOwnerStatus() == status)
                .collect(Collectors.toList());
    }

    // ------------------------------------------------------------------------
    // LEGACY / WRAPPER METHODS
    // ------------------------------------------------------------------------

    @Override
    public List<GymCenter> viewPendingGyms() {
        // Re-use the functional method above for "PENDING"
        return filterGymCentersByStatus(GymStatus.PENDING);
    }

    @Override
    public List<GymOwner> viewPendingOwners() {
        // Re-use the functional method above for "PENDING"
        return filterGymOwnersByStatus(GymStatus.PENDING);
    }
}