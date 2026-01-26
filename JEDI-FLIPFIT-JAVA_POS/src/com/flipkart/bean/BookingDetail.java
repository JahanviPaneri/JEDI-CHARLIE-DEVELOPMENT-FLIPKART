package com.flipkart.bean;

import com.flipkart.constants.BookingStatus;
import java.util.Date;

public class BookingDetail {

    private String bookingDetailId;
    private String userId;
    private String gymId;
    private String slotId;
    private BookingStatus status;
    private Date date;
    private Payment paymentDetails;

    public BookingDetail(String bookingDetailId, String userId, String gymId, String slotId, BookingStatus status, Date date, Payment paymentDetails) {
        this.bookingDetailId = bookingDetailId;
        this.userId = userId;
        this.gymId = gymId;
        this.slotId = slotId;
        this.status = status;
        this.date = date;
        this.paymentDetails = paymentDetails;
    }

    public String getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(String bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Payment paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}