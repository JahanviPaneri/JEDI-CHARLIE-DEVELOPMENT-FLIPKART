package com.flipfit.business;

/**
 * Interface for handling financial transactions and refunds.
 */
public interface PaymentInterface {

    // Handle the billing process for a user's gym booking
    boolean processPayment(String userId, double amount);

    // Start a return request for a specific transaction
    void requestRefund(String paymentId);
}