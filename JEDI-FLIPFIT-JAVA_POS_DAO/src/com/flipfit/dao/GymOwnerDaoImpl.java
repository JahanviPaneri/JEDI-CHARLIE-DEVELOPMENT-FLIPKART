package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import com.flipfit.utils.DBConnection;
import com.flipfit.constant.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access implementation for managing Gym Owners in memory.
 */
public class GymOwnerDaoImpl implements GymOwnerDaoInterface {

    @Override
    public void addGymOwner(GymOwner owner) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.INSERT_GYM_OWNER)) {

            pstmt.setString(1, owner.getOwnerId());
            pstmt.setString(2, owner.getName());
            pstmt.setString(3, owner.getEmail());
            pstmt.setString(4, owner.getPhoneNumber());
            pstmt.setString(5, owner.getPanNumber());
            pstmt.setString(6, owner.getAadharNumber());
            pstmt.setString(7, "PENDING"); // Default status

            pstmt.executeUpdate();
            System.out.println("DAO: Gym Owner registered in DB: " + owner.getOwnerId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GymOwner getOwnerById(String ownerId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_GYM_OWNER_BY_ID)) {

            pstmt.setString(1, ownerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapResultSetToOwner(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public GymOwner getOwnerByEmail(String email) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_GYM_OWNER_BY_EMAIL)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapResultSetToOwner(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<GymOwner> getAllOwners() {
        List<GymOwner> owners = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_ALL_GYM_OWNERS)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) owners.add(mapResultSetToOwner(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return owners;
    }

    @Override
    public void deleteOwner(String ownerId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.DELETE_GYM_OWNER)) {

            pstmt.setString(1, ownerId);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private GymOwner mapResultSetToOwner(ResultSet rs) throws SQLException {
        GymOwner owner = new GymOwner();
        owner.setOwnerId(rs.getString("ownerId"));
        owner.setName(rs.getString("name"));
        owner.setEmail(rs.getString("email"));
        owner.setPhoneNumber(rs.getString("phoneNumber"));
        owner.setPanNumber(rs.getString("panNumber"));
        owner.setAadharNumber(rs.getString("aadharNumber"));
        return owner;
    }
}