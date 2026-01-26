package com.flipkart.business;


public interface NotificationInterface {
    void sendNotification(String userId, String message);
    void markAsRead(String notificationId);
}