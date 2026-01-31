package com.flipfit.business;

import com.flipfit.bean.Booking;
import java.util.List;

/**
 * Interface for managing gym slot bookings and cancellations.
 */
public interface BookingInterface {

    // Create a new booking for a customer at a specific gym and time
    void makeBooking(String userId, String gymId, String slotId, String date);

    // Remove an existing booking using its unique ID
    void cancelBooking(String bookingId);

    // Get a list of all gym bookings made by a specific customer
    List<Booking> getCustomerBookings(String userId);
}