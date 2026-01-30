package com.flipfit.business;

import com.flipfit.bean.User;
import com.flipfit.exception.InvalidCredentialsException;

/**
 * Interface for general user operations and account security.
 */
public interface UserInterface {
    /**
     * Registers a new user in the system.
     * @param user The user object to register
     */
    void registerUser(User user);

    /**
     * Validates user credentials and returns the User object if successful.
     * @param email The user's email
     * @param password The user's password
     * @return User object containing role and details
     * @throws InvalidCredentialsException if validation fails
     */
    User login(String email, String password,String role) throws InvalidCredentialsException;

    void updatePassword(String userId, String newPassword);

    // Retrieve all profile information for a specific user ID
    User getUserDetails(String userId);
}