package com.flipkart.bean;

import com.flipkart.constants.WaitlistStatus;
import java.util.Date;

public class WaitListDetail {

    private String waitlistDetailId;
    private String userId;
    private String gymId;
    private String slotId;
    private WaitlistStatus status;
    private Date date;
    private String paymentId;

    public WaitListDetail(String waitlistDetailId, String userId, String gymId, String slotId, WaitlistStatus status, Date date, String paymentId) {
        this.waitlistDetailId = waitlistDetailId;
        this.userId = userId;
        this.gymId = gymId;
        this.slotId = slotId;
        this.status = status;
        this.date = date;
        this.paymentId = paymentId;
    }

    public String getWaitlistDetailId() {
        return waitlistDetailId;
    }

    public void setWaitlistDetailId(String waitlistDetailId) {
        this.waitlistDetailId = waitlistDetailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public WaitlistStatus getStatus() {
        return status;
    }

    public void setStatus(WaitlistStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}