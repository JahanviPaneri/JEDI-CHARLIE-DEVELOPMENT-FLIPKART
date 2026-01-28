package com.flipfit.dao;

import com.flipfit.bean.Booking;
import com.flipfit.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data Access implementation for managing gym bookings in memory.
 */
public class BookingDaoImpl implements BookingDaoInterface {

    // In-memory storage for bookings using a Map
    private static final Map<String, Booking> bookingMap = new HashMap<>();

    @Override
    public void addBooking(Booking booking) {
        // Save a new booking record into the map
        bookingMap.put(booking.getBookingId(), booking);
        System.out.println("DAO: Booking saved with ID " + booking.getBookingId());
    }

    @Override
    public void cancelBooking(String bookingId) {
        // Remove a booking record using its unique ID
        if (!bookingMap.containsKey(bookingId)) {
            throw new ResourceNotFoundException("Booking ID " + bookingId + " not found.");
        }
        bookingMap.remove(bookingId);
    }

    @Override
    public Booking getBookingById(String bookingId) {
        // Search for a specific booking in the map
        return bookingMap.get(bookingId);
    }

    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        // Filter and return all bookings made by a specific user
        return bookingMap.values().stream()
                .filter(booking -> booking.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}