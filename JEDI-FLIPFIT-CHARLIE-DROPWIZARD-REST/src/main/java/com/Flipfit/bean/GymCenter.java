package com.Flipfit.bean;

import com.Flipfit.constants.GymStatus;

public class GymCenter {
    private String gymId;
    private String gymName;
    private String gymLocation;
    private String ownerId;
    private GymStatus gymStatus;

    public GymCenter() {
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public GymStatus getGymStatus() {
        return gymStatus;
    }

    public void setGymStatus(GymStatus gymStatus) {
        this.gymStatus = gymStatus;
    }
}
