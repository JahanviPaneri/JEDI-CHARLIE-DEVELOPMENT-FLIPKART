package com.flipfit.dao;

import com.flipfit.bean.Booking;
import java.util.List;

/**
 * Interface for database operations related to gym bookings.
 */
public interface BookingDaoInterface {

    // Save a new booking entry into the storage
    void addBooking(Booking booking);

    // Permanently delete a booking record from the storage
    void cancelBooking(String bookingId);

    // Find and return a specific booking using its unique ID
    Booking getBookingById(String bookingId);

    // Get a list of all bookings associated with a specific user
    List<Booking> getBookingsByUserId(String userId);
}