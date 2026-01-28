package com.flipfit.business;

import com.flipfit.bean.Booking;
import java.util.List;

public interface BookingInterface {
    // Core booking logic
    void makeBooking(String userId, String gymId, String slotId, String date);
    void cancelBooking(String bookingId);

    // View bookings
    List<Booking> getCustomerBookings(String userId);
}