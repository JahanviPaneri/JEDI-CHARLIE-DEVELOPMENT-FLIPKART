package com.flipkart.bean;

public class Waitlist {

    private String waitlistId;
    private String waitlistDetailId;
    private int priority;

    public Waitlist(String waitlistId, String waitlistDetailId, int priority) {
        this.waitlistId = waitlistId;
        this.waitlistDetailId = waitlistDetailId;
        this.priority = priority;
    }

    public String getWaitlistId() {
        return waitlistId;
    }

    public void setWaitlistId(String waitlistId) {
        this.waitlistId = waitlistId;
    }

    public String getWaitListDetailId() {
        return waitlistDetailId;
    }

    public void setWaitListDetailId(String waitlistDetailId) {
        this.waitlistDetailId = waitlistDetailId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}