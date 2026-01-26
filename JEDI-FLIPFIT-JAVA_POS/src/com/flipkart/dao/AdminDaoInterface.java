package com.flipkart.dao;

import com.flipkart.bean.Admin;
import java.util.List;

public interface AdminDaoInterface {
    /**
     * Adds an Admin to the system
     * @param admin The admin object to be stored
     */
    void addAdmin(Admin admin);

    /**
     * Retrieves Admin by their unique adminId
     * @param adminId Unique ID of the admin
     * @return Admin object
     */
    Admin getAdminById(String adminId);

    /**
     * Retrieves Admin by email for login purposes
     * @param email Admin email address
     * @return Admin object
     */
    Admin getAdminByEmail(String email);

    /**
     * Returns a list of all administrators
     * @return List of Admin objects
     */
    List<Admin> getAllAdmins();
}