package com.Flipfit.buisness;

import com.Flipfit.bean.*;
import com.Flipfit.dao.*;
import com.Flipfit.dao.AdminDaoInterface;

import java.util.List;
import java.util.UUID;

public class AdminService implements AdminInterface {
    private AdminDaoInterface adminDao = new AdminDaoImpl();
    private UserDaoInterface userDao = new UserDaoImpl();

    @Override
    public void registerAdmin(String name, String email, String phoneNumber, String password) {
        String userId = UUID.randomUUID().toString();
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");

        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPasswordHash(password);
        user.setRole(String.valueOf(adminRole));

        Admin admin = new Admin();
        admin.setUserId(userId);
        admin.setAdminId(UUID.randomUUID().toString());
        admin.setName(name);
        admin.setEmail(email);
        admin.setPhoneNumber(phoneNumber);
        admin.setPasswordHash(password);
        admin.setRole(String.valueOf(adminRole));

        userDao.addUser(user);
        adminDao.addAdmin(admin);
        System.out.println("Registration successful for Admin: " + name);
    }

    @Override
    public void approveGymCenter(String gymId) {
        adminDao.approveGymCenter(gymId);
        System.out.println("Admin approved Gym ID: " + gymId);
    }

    @Override
    public void approveGymOwner(String ownerId) {
        adminDao.approveGymOwner(ownerId);
        System.out.println("Admin approved Owner ID: " + ownerId);
    }

    @Override
    public List<GymCenter> viewPendingGyms() {
        return adminDao.viewPendingGyms();
    }

    @Override
    public List<GymOwner> viewPendingOwners() {
        return adminDao.viewPendingOwners();
    }
}