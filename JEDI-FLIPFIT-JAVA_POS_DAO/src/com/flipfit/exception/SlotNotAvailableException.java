package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class SlotNotAvailableException.
 * Custom exception thrown when a requested slot is not available for booking.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class SlotNotAvailableException extends Exception {

    /**
     * Instantiates a new slot not available exception.
     */
    public SlotNotAvailableException() {
        super("The requested slot is not available.");
    }

    /**
     * Instantiates a new slot not available exception with custom message.
     *
     * @param message the detail message
     */
    public SlotNotAvailableException(String message) {
        super(message);
    }

    /**
     * Instantiates a new slot not available exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public SlotNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
