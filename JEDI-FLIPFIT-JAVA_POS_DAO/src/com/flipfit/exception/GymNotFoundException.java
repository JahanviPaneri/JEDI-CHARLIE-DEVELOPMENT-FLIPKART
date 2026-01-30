package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class GymNotFoundException.
 * Custom exception thrown when a gym center cannot be found in the system.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class GymNotFoundException extends Exception {

    /**
     * Instantiates a new gym not found exception.
     */
    public GymNotFoundException() {
        super("Gym center not found in the system.");
    }

    /**
     * Instantiates a new gym not found exception with custom message.
     *
     * @param message the detail message
     */
    public GymNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new gym not found exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public GymNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
