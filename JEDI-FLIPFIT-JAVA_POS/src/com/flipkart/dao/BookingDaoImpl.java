package com.flipkart.dao;

import com.flipkart.bean.Booking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingDaoImpl implements BookingDaoInterface {
    private static final Map<String, Booking> bookingMap = new HashMap<>();

    @Override
    public void addBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    @Override
    public void cancelBooking(String bookingId) {
        bookingMap.remove(bookingId);
    }

    @Override
    public Booking getBookingById(String bookingId) {
        return bookingMap.get(bookingId);
    }

    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        return bookingMap.values().stream()
                .filter(booking -> booking.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}