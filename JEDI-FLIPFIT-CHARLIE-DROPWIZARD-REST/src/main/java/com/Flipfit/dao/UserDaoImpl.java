package com.Flipfit.dao;

import com.Flipfit.bean.User;

public class UserDaoImpl implements UserDaoInterface {
    @Override
    public void addUser(User user) {
        // SQL Logic: INSERT INTO User (userId, name, email, passwordHash, roleId) VALUES (?,?,?,?,?);
        System.out.println("DAO: User record created in base table for: " + user.getName());
    }
}
