package com.flipkart.bean;

import java.sql.Time;

public class Notification {

    private String notificationId;
    private String userId;
    private String message;
    private Time time;
    private String status;

    public Notification(String notificationId, String userId, String message, Time time, String status) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.time = time;
        this.status = status;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}