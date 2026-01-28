package com.flipfit.business;

import com.flipfit.bean.User;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserInterface {

    // Temporary in-memory list to act as a database
    private List<User> users = new ArrayList<>();

    @Override
    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered successfully: " + user.getName());
    }

    @Override
    public boolean login(String email, String password) {
        // Logic to verify email and passwordHash
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPasswordHash().equals(password)) {
                System.out.println("Login successful for: " + u.getName());
                return true;
            }
        }
        return false;
    }

    @Override
    public void updatePassword(String userId, String newPassword) {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                u.setPasswordHash(newPassword);
                System.out.println("Password updated.");
            }
        }
    }

    @Override
    public User getUserDetails(String userId) {
        return users.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}