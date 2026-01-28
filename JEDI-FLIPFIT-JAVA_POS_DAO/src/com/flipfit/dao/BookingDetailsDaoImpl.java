package com.flipfit.dao;

import com.flipfit.bean.BookingDetail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data Access implementation for managing specific booking details in memory.
 */
public class BookingDetailsDaoImpl implements BookingDetailsDaoInterface {

    // In-memory collection to store detailed information for each booking
    private static final Map<String, BookingDetail> detailsMap = new HashMap<>();

    @Override
    public void addBookingDetail(BookingDetail detail) {
        // Store a new set of booking details into the map
        detailsMap.put(detail.getBookingDetailId(), detail);
    }

    @Override
    public BookingDetail getDetailByBookingId(String bookingId) {
        // Search for details that match a specific booking record ID
        return detailsMap.values().stream()
                .filter(detail -> detail.getBookingDetailId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BookingDetail> getAllDetailsByUserId(String userId) {
        // Filter and return all booking details associated with a specific user
        return detailsMap.values().stream()
                .filter(detail -> detail.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}