package com.flipkart.business;

public class NotificationService implements NotificationInterface {
    @Override
    public void sendNotification(String userId, String message) {
        // DAO: save notification to DB for the user to see later
        System.out.println("Notification sent to " + userId + ": " + message);
    }

    @Override
    public void markAsRead(String notificationId) { }
}
