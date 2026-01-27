package com.flipkart.dao;

import com.flipkart.bean.Admin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDaoImpl implements AdminDaoInterface {

    // Key: adminId, Value: Admin Object
    private static final Map<String, Admin> adminMap = new HashMap<>();

    @Override
    public void addAdmin(Admin admin) {
        adminMap.put(admin.getAdminId(), admin);
        System.out.println("DAO: Admin added successfully with ID: " + admin.getAdminId());
    }

    @Override
    public Admin getAdminById(String adminId) {
        return adminMap.get(adminId);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        // Stream values to find an email match
        return adminMap.values().stream()
                .filter(admin -> admin.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return new ArrayList<>(adminMap.values());
    }
}