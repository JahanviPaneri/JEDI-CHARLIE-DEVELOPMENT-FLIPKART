package com.Flipfit.bean;

public class Admin extends User {
    private String adminID;

    public Admin(){

    }

    public void setAdminId(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminId() {
        return this.adminID;
    }
}
