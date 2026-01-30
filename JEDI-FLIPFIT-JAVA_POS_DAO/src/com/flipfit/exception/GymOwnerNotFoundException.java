package com.flipfit.exception;

/**
 * The Class GymOwnerNotFoundException.
 * Custom exception thrown when a gym owner cannot be found in the system.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class GymOwnerNotFoundException extends RuntimeException {

    /**
     * Instantiates a new gym owner not found exception.
     */
    public GymOwnerNotFoundException() {
        super("Gym Owner not found. Please check the ID and try again.");
    }

    /**
     * Instantiates a new gym owner not found exception with custom message.
     *
     * @param message the detail message
     */
    public GymOwnerNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new gym owner not found exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public GymOwnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}