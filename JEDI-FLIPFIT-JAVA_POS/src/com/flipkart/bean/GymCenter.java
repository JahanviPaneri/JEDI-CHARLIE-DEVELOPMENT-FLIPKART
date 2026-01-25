package flipkart.bean;

import flipkart.constants.GymStatus;

public class GymCenter {

    private String gymId;
    private String gymName;
    private String gymLocation;
    private GymStatus gymStatus;
    private String gymOwnerId;

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    public GymStatus getGymStatus() {
        return gymStatus;
    }

    public void setGymStatus(GymStatus gymStatus) {
        this.gymStatus = gymStatus;
    }



}
