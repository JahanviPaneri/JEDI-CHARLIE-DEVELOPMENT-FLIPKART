package com.flipfit.business;

import com.flipfit.bean.User;

public interface UserInterface {
    // Basic authentication and management
    void registerUser(User user);
    boolean login(String email, String password);
    void updatePassword(String userId, String newPassword);
    User getUserDetails(String userId);
}