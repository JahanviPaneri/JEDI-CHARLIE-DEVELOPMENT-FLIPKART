package com.Flipfit.dao;

import com.Flipfit.bean.Admin;
import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;
import com.Flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDaoInterface {
    @Override
    public void addAdmin(Admin admin) {
        // SQL Logic: INSERT INTO Admin (adminId, name, email...) VALUES (?, ?, ?);
        System.out.println("DAO: Admin added to database: " + admin.getName());
    }

    @Override
    public void approveGymCenter(String gymId) {
        String sql = "UPDATE Gym SET status = 'APPROVED' WHERE gymId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gymId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void approveGymOwner(String ownerId) {
        String sql = "UPDATE GymOwner SET isApproved = true WHERE ownerId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ownerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GymCenter> viewPendingGyms() {
        List<GymCenter> pendingGyms = new ArrayList<>();
        return pendingGyms;
    }

    @Override
    public List<GymOwner> viewPendingOwners() {
        // SQL Logic: SELECT * FROM GymOwner WHERE isApproved = false;
        List<GymOwner> pendingOwners = new ArrayList<>();
        return pendingOwners;
    }
}