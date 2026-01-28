package com.flipfit.business;

/**
 * Interface for sending and managing user alerts and updates.
 */
public interface NotificationInterface {

    // Send a specific alert or message to a user's account
    void sendNotification(String userId, String message);

    // Mark a specific notification as seen by the user
    void markAsRead(String notificationId);
}