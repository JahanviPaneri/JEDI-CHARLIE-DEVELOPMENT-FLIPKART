package com.flipfit.bean;

public class Admin extends User {
    private String adminID;

    public void setAdminId(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminId() {
        return this.adminID;
    }
}