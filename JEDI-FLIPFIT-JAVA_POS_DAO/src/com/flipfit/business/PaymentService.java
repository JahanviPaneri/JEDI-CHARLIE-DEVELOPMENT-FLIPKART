package com.flipfit.business;

/**
 * Service implementation for handling financial transactions and refunds.
 */
public class PaymentService implements PaymentInterface {

    @Override
    public boolean processPayment(String userId, double amount) {
        // Log and confirm the successful deduction of fees from the user
        System.out.println("Payment of " + amount + " processed for user " + userId);
        return true;
    }

    @Override
    public void requestRefund(String paymentId) {
        // Start the process to return money back to the original payment source
        System.out.println("Refund initiated for Payment ID: " + paymentId);
    }
}