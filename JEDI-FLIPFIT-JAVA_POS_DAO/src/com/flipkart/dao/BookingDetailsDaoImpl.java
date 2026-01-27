package com.flipkart.dao;

import com.flipkart.bean.BookingDetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingDetailsDaoImpl implements BookingDetailsDaoInterface {
    private static final Map<String, BookingDetail> detailsMap = new HashMap<>();

    @Override
    public void addBookingDetail(BookingDetail detail) {
        detailsMap.put(detail.getBookingDetailId(), detail);
    }

    @Override
    public BookingDetail getDetailByBookingId(String bookingId) {
        return detailsMap.values().stream()
                .filter(detail -> detail.getBookingDetailId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BookingDetail> getAllDetailsByUserId(String userId) {
        return detailsMap.values().stream()
                .filter(detail -> detail.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}