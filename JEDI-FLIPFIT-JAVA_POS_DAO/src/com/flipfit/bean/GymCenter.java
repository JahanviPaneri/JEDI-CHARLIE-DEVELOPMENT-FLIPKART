package com.flipfit.bean;

import com.flipfit.constants.GymStatus;

public class GymCenter {

    private String gymId;
    private String gymName;
    private String gymLocation;
    private GymStatus gymStatus;
    private String gymOwnerId;
    private int capacity;


    public GymCenter(){}


    public GymCenter(String gymId, String gymName, String gymLocation, GymStatus gymStatus, String gymOwnerId, int capacity) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.gymLocation = gymLocation;
        this.gymStatus = gymStatus;
        this.gymOwnerId = gymOwnerId;
        this.capacity = capacity;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    public GymStatus getGymStatus() {
        return gymStatus;
    }

    public void setGymStatus(GymStatus gymStatus) {
        this.gymStatus = gymStatus;
    }

    public String getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}