package com.flipkart.bean;

import com.flipkart.constants.PaymentStatus;
import java.sql.Time;

public class Payment {

    private String paymentId;
    private String bookingId;
    private double amount;
    private String method;
    private Time time;
    private PaymentStatus status;
    private String senderUserId;
    private String receiverUserId;

    public Payment(String paymentId, String bookingId, double amount, String method, Time time, PaymentStatus status, String senderUserId, String receiverUserId) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.method = method;
        this.time = time;
        this.status = status;
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(String receiverUserId) {
        this.receiverUserId = receiverUserId;
    }
}