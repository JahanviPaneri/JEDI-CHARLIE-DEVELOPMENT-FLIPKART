package com.flipfit.dao;

import com.flipfit.bean.BookingDetail;
import java.util.List;

public interface BookingDetailsDaoInterface {
    void addBookingDetail(BookingDetail detail);
    BookingDetail getDetailByBookingId(String bookingId);
    List<BookingDetail> getAllDetailsByUserId(String userId);
}