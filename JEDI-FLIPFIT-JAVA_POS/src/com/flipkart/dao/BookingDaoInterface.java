package com.flipkart.dao;

import com.flipkart.bean.Booking;
import java.util.List;

public interface BookingDaoInterface {
    void addBooking(Booking booking);
    void cancelBooking(String bookingId);
    Booking getBookingById(String bookingId);
    List<Booking> getBookingsByUserId(String userId);
}