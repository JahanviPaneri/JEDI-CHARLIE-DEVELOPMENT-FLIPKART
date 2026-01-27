package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipfit.utils.DBConnection;
import com.flipfit.constant.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminDaoImpl.
 * Implementation of AdminDaoInterface providing database operations for Admin entities.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class AdminDaoImpl implements AdminDaoInterface {

    /**
     * Adds the admin to the database.
     *
     * @param admin the admin object to be added
     */
    @Override
    public void addAdmin(Admin admin) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.INSERT_ADMIN)) {

            pstmt.setString(1, admin.getAdminId());
            pstmt.setString(2, admin.getName());
            pstmt.setString(3, admin.getEmail());
            pstmt.setString(4, admin.getUserId());

            pstmt.executeUpdate();
            System.out.println("DAO: Admin registered successfully in DB with ID: " + admin.getAdminId());
        } catch (SQLException e) {
            System.err.println("Error adding admin: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets the admin by id.
     *
     * @param adminId the admin id
     * @return the admin object if found, null otherwise
     */
    @Override
    public Admin getAdminById(String adminId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_ADMIN_BY_ID)) {

            pstmt.setString(1, adminId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToAdmin(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the admin by email.
     *
     * @param email the email address
     * @return the admin object if found, null otherwise
     */
    @Override
    public Admin getAdminByEmail(String email) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_ADMIN_BY_EMAIL)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToAdmin(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all admins from the database.
     *
     * @return the list of all admins
     */
    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_ALL_ADMINS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                admins.add(mapResultSetToAdmin(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    /**
     * Map result set to admin.
     * Helper method to convert database result set to Admin bean.
     *
     * @param rs the result set from database query
     * @return the admin object
     * @throws SQLException the SQL exception
     */
    private Admin mapResultSetToAdmin(ResultSet rs) throws SQLException {
        Admin admin = new Admin();
        admin.setAdminId(rs.getString("adminId"));
        admin.setName(rs.getString("name"));
        admin.setEmail(rs.getString("email"));
        admin.setUserId(rs.getString("userId"));
        return admin;
    }
}