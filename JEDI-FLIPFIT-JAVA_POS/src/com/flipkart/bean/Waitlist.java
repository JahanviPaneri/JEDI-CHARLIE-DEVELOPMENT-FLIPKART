package flipkart.bean;

public class Waitlist {
    private String waitlistId;        // Unique identifier for the waitlist entry

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getWaitListDetailId() {
        return waitlistDetailId;
    }

    public void setWaitListDetailId(String waitListDetailId) {
        this.waitlistDetailId = waitListDetailId;
    }

    public String getWaitlistId() {
        return waitlistId;
    }

    public void setWaitlistId(String waitlistId) {
        this.waitlistId = waitlistId;
    }

    private String waitlistDetailId;  // Reference to the immutable snapshot of the waitlist info
    private int priority;
}
