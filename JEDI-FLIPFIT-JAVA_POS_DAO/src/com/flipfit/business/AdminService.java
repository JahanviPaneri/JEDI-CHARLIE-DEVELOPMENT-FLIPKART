package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.bean.GymCenter;
import com.flipfit.dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminService implements AdminInterface {
    GymCenterDaoInterface gymCenterDao = new GymCenterDaoImpl();
    GymOwnerDaoInterface gymOwnerDao = new GymOwnerDaoImpl();
    //    public void registerAdmin(String name, String email, String phoneNumber, String password) {
//        // 1. Create a unique ID for the user
//        String userId = UUID.randomUUID().toString();
//
//        // 2. Set up the User bean (for the User table)
//        Admin admin = new Admin();
//        User user = new User();
//        admin.setUserId(userId);
//        admin.setAdminId(UUID.randomUUID().toString());
//        admin.setName(name);
//        admin.setEmail(email);
//        admin.setPhoneNumber(phoneNumber);
//        admin.setPasswordHash(password); // In production, use hashing
//
//        // 3. Set the Role
//        Role adminRole = new Role();
//        adminRole.setRoleName("Admin");
//        admin.setRole(adminRole);
//
//        // 4. Save to User table via UserDao
//        UserDaoImpl.addUser(user);
//
//        // 5. Save to Admin table via AdminDao
//        AdminDaoImpl.addAdmin(admin);
//
//        System.out.println("Business: Admin registered successfully for: " + name);
//    }
    @Override
    public void registerAdmin(String name, String email, String phoneNumber, String password, String aadharNumber, String panNumber) {
        // 1. Generate IDs
        String userId = UUID.randomUUID().toString();
        String adminId = UUID.randomUUID().toString();

        // 2. Set up the Role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");

        // 3. Create and populate the User object
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPasswordHash(password);
        user.setRole(adminRole);
        // 4. Create and populate the Admin object (carrying the same User data)
        Admin admin = new Admin();
        admin.setUserId(userId); // Links Admin to the User table
        admin.setAdminId(adminId);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPhoneNumber(phoneNumber);
        admin.setAadharNumber(aadharNumber);
        admin.setPanNumber(panNumber);
        admin.setPasswordHash(password);
        admin.setRole(adminRole);

        // 5. Save to User table via UserDao
        // Note: ensure you are calling the method on an instance or the class correctly
        UserDaoInterface userDao = new UserDaoImpl();
        userDao.addUser(user);

        // 6. Save to Admin table via AdminDao
        AdminDaoInterface adminDao = new AdminDaoImpl();
        adminDao.addAdmin(admin);

        System.out.println("Registration successful for Admin: " + name);
    }
    @Override
    public void approveGymCenter(String gymId) {
        boolean success = gymCenterDao.changeGymCenterStatus(gymId);

        if (success) {
            System.out.println("Service: GYM " + gymId + " successfully moved from PENDING to APPROVED.");
        } else {
            System.out.println("Service: Approval failed. Gym might not exist or isn't in PENDING status.");
        }
    }

    @Override
    public void approveGymOwner(String ownerId) {
        // The Service Layer handles the business result
        boolean success = gymOwnerDao.updateOwnerStatusToApproved(ownerId);

        if (success) {
            System.out.println("Service: Owner " + ownerId + " successfully moved from PENDING to APPROVED.");
        } else {
            System.out.println("Service: Approval failed. Owner might not exist or isn't in PENDING status.");
        }
    }

    @Override
    public List<GymCenter> viewPendingGyms() {
        // Fetching real data from the database via the DAO
        List<GymCenter> pendingGyms = gymCenterDao.getPendingGyms();

        if (pendingGyms.isEmpty()) {
            System.out.println("No pending gym center requests found.");
        } else {
            System.out.println("\n--- Pending Gym Center Requests ---");
            // Standardized console table format
            System.out.printf("%-10s | %-20s | %-15s | %-10s%n", "Gym ID", "Gym Name", "Location", "Owner ID");
            System.out.println("----------------------------------------------------------------------");

            pendingGyms.forEach(gym -> {
                System.out.printf("%-10s | %-20s | %-15s | %-10s%n",
                        gym.getGymId(),
                        gym.getGymName(),
                        gym.getGymLocation(),
                        gym.getGymOwnerId());
            });
        }
        return pendingGyms;
    }

    @Override
    public List<GymOwner> viewPendingOwners() {

        // Fetching real data from the database via the DAO
        List<GymOwner> pendingOwners = gymOwnerDao.getPendingOwners();

        if (pendingOwners.isEmpty()) {
            System.out.println("No pending gym owner requests found.");
        } else {
            System.out.println("\n--- Pending Gym Owner Requests ---");
            // Standardized console table format
            System.out.printf("%-15s | %-20s | %-15s%n","Owner ID", "Account No", "PAN No");
            System.out.println("----------------------------------------------------------------------");


            for (GymOwner owner : pendingOwners) {
                System.out.printf("%-15s | %-20s | %-15s%n",
                        owner.getOwnerId(),
                        owner.getAccountNumber(),
                        owner.getPanNumber()
                );
            }

        }
        return pendingOwners;
    }
}
