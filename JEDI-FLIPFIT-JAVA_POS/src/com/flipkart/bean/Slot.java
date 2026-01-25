package flipkart.bean;

public class Slot {

    private String slotId;
    private String startTime;
    private String endTime;
    private String gymId;
    private String date;
    private int totalCapacity;
    private int availableCapacity;

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }


}
