package com.flipkart.bean;

public class Admin extends User {
    private String adminID;

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminId() {
        return this.adminID;
    }
}