package com.flipkart.business;

public class PaymentService implements PaymentInterface {
    @Override
    public boolean processPayment(String userId, double amount) {
        System.out.println("Payment of " + amount + " processed for user " + userId);
        return true;
    }

    @Override
    public void requestRefund(String paymentId) {
        System.out.println("Refund initiated for Payment ID: " + paymentId);
    }
}