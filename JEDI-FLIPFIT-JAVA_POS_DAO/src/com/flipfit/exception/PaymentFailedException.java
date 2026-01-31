package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentFailedException.
 * Custom exception thrown when a payment transaction fails.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class PaymentFailedException extends Exception {

    /**
     * Instantiates a new payment failed exception.
     */
    public PaymentFailedException() {
        super("Payment transaction failed. Please try again.");
    }

    /**
     * Instantiates a new payment failed exception with custom message.
     *
     * @param message the detail message
     */
    public PaymentFailedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new payment failed exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public PaymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
