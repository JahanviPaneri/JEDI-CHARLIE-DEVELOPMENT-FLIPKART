package com.flipfit.bean;

import com.flipfit.constants.GymStatus;

public class GymOwner extends User {

    private String ownerId;
    private String accountNumber;
    private String panNumber;
    private GymStatus gymStatus;


    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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

    public GymStatus getOwnerStatus() {
        return gymStatus;
    }

    public void setOwnerStatus(GymStatus gymStatus) {
        this.gymStatus = gymStatus;
    }
}