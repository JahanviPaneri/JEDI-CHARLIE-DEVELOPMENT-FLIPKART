package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.bean.Role;
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
 * The Class UserDaoImpl.
 * Implementation of UserDaoInterface providing database operations for User entities.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class UserDaoImpl implements UserDaoInterface {

    /**
     * Adds the user to the database.
     *
     * @param user the user object to be added
     */
    @Override
    public void addUser(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.INSERT_USER)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPasswordHash());
            pstmt.setString(5, user.getPhoneNumber());
            pstmt.setString(6, user.getRole() != null ? user.getRole().getRoleName() : null);

            pstmt.executeUpdate();
            System.out.println("DAO: User registered successfully in DB with ID: " + user.getUserId());
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets the user by id.
     *
     * @param userId the user id
     * @return the user object if found, null otherwise
     */
    @Override
    public User getUserById(String userId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_USER_BY_ID)) {

            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the user by email.
     *
     * @param email the email address
     * @return the user object if found, null otherwise
     */
    @Override
    public User getUserByEmail(String email) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_USER_BY_EMAIL)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all users from the database.
     *
     * @return the list of all users
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_ALL_USERS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Map result set to user.
     * Helper method to convert database result set to User bean.
     *
     * @param rs the result set from database query
     * @return the user object
     * @throws SQLException the SQL exception
     */
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("userId"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPasswordHash(rs.getString("passwordHash"));
        user.setPhoneNumber(rs.getString("phoneNumber"));

        Role role = new Role();
        role.setRoleName(rs.getString("roleName"));
        user.setRole(role);

        return user;
    }
}