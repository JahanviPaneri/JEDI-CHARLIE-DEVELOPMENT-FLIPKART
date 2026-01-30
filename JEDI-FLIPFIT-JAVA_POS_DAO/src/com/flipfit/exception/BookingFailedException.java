package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingFailedException.
 * Custom exception thrown when a booking operation fails.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class BookingFailedException extends Exception {

    /**
     * Instantiates a new booking failed exception.
     */
    public BookingFailedException() {
        super("Booking operation failed. Please try again.");
    }

    /**
     * Instantiates a new booking failed exception with custom message.
     *
     * @param message the detail message
     */
    public BookingFailedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new booking failed exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public BookingFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
