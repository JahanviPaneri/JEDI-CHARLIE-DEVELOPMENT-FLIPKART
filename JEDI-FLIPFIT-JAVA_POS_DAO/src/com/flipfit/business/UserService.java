package com.flipfit.business;

import com.flipfit.bean.User;
import com.flipfit.dao.UserDaoImpl;
import com.flipfit.dao.UserDaoInterface;
import com.flipfit.exception.InvalidCredentialsException;

import java.util.List;

/**
 * Service implementation for shared user tasks like login and account management.
 */
public class UserService implements UserInterface {

    private UserDaoInterface userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.addUser(user);
        System.out.println("User registered successfully: " + user.getName());
    }

    @Override
    public User login(String email, String password,String role) throws InvalidCredentialsException {
        // 1. Retrieve user by email from the database
        User user = userDao.getUserByEmail(email);

        // 2. Check if user exists and password matches
        if (user == null || !user.getPasswordHash().equals(password)) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }
        if (role == null || !user.getRole().getRoleName().equals(role)) {
            throw new InvalidCredentialsException("role not found.");
        }

        // 3. Return the authenticated user (including Role)
        System.out.println("Login successful for: " + user.getName() + " [" + user.getRole().getRoleName() + "]");
        return user;
    }

    @Override
    public void updatePassword (String email, String role,String password ,String updatedPassword) throws InvalidCredentialsException{
        // Implementation logic for password update
        // userDao.updatePassword(userId, newPassword);

        User user = userDao.getUserByEmail(email);

        if (user == null || !user.getPasswordHash().equals(password)) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }

        if (role == null || !user.getRole().getRoleName().equals(role)) {
            throw new InvalidCredentialsException("role not found.");
        }

        user.setPasswordHash(updatedPassword);
        userDao.updatePassword(user);

    }

    @Override
    public User getUserDetails(String userId) {
        return userDao.getUserById(userId);
    }
}