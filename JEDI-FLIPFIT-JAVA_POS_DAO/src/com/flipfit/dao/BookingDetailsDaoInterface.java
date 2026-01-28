package com.flipfit.dao;

import com.flipfit.bean.BookingDetail;
import java.util.List;

/**
 * Interface for database operations related to detailed booking information.
 */
public interface BookingDetailsDaoInterface {

    // Save detailed information about a specific gym booking
    void addBookingDetail(BookingDetail detail);

    // Retrieve details like gym name and slot time for a specific booking
    BookingDetail getDetailByBookingId(String bookingId);

    // Get a full history of detailed bookings for a specific user
    List<BookingDetail> getAllDetailsByUserId(String userId);
}