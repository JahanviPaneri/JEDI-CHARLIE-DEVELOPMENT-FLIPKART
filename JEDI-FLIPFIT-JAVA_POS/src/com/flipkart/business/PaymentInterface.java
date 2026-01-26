package com.flipkart.business;

public interface PaymentInterface {
    boolean processPayment(String userId, double amount);
    void requestRefund(String paymentId);
}

