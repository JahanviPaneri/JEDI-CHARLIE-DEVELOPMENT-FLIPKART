package com.flipfit.business;

/**
 * Service implementation for managing user alerts and communication.
 */
public class NotificationService implements NotificationInterface {

    @Override
    public void sendNotification(String userId, String message) {
        // Logic to save a new alert message for a specific user in the database
        System.out.println("Notification sent to " + userId + ": " + message);
    }

    @Override
    public void markAsRead(String notificationId) {
        // Logic to update the notification status so the user knows they have seen it
        System.out.println("Notification ID " + notificationId + " has been marked as read.");
    }
}