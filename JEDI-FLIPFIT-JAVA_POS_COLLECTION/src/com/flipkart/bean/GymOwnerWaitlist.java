package com.flipfit.bean;

public class GymOwnerWaitlist {
    
    private String ownerId;
    private String email;
    private String password;
    private String accountNumber;
    private String panNumber;

    public GymOwnerWaitlist() {}

    public GymOwnerWaitlist(String ownerId, String email, String password, String accountNumber, String panNumber) {
        this.ownerId = ownerId;
        this.email = email;
        this.password = password;
        this.accountNumber = accountNumber;
        this.panNumber = panNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
