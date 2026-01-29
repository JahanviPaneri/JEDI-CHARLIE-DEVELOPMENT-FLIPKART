package com.flipfit.dao;

import com.flipfit.bean.User;
import java.util.List;

public interface UserDaoInterface {
    /**
     * Registers a new user in the database
     * @param user The User object containing details
     */
    void addUser(User user);

    /**
     * Retrieves a user based on their unique ID
     * @param userId The ID of the user
     * @return User object or null if not found
     */
    User getUserById(String userId);

    /**
     * Retrieves a user based on their email
     * @param email The email of the user
     * @return User object or null if not found
     */
    User getUserByEmail(String email);

    /**
     * Retrieves all registered users
     * @return List of User objects
     */
    List<User> getAllUsers();

    void updatePassword(User user);
}