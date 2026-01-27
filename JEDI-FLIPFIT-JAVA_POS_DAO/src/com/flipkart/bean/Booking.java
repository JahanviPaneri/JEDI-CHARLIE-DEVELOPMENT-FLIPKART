package com.flipkart.bean;

public class Booking {
    private String bookingId;
    private String bookingDetailId;

    public Booking(String bookingId, String bookingDetailId) {
        this.bookingId = bookingId;
        this.bookingDetailId = bookingDetailId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(String bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }


    public String getUserId() {
        return this.getUserId();
    }
}