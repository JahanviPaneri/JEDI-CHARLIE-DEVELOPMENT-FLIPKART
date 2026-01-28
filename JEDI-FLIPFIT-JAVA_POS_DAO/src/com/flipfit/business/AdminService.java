package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.AdminDaoImpl;
import com.flipfit.dao.AdminDaoInterface;
import com.flipfit.dao.UserDaoImpl;
import com.flipfit.dao.UserDaoInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminService implements AdminInterface {

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
    public void registerAdmin(String name, String email, String phoneNumber, String password) {
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