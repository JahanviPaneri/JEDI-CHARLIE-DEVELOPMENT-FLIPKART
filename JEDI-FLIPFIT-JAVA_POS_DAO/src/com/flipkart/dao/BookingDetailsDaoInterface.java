package com.flipkart.dao;

import com.flipkart.bean.BookingDetail;
import java.util.List;

public interface BookingDetailsDaoInterface {
    void addBookingDetail(BookingDetail detail);
    BookingDetail getDetailByBookingId(String bookingId);
    List<BookingDetail> getAllDetailsByUserId(String userId);
}