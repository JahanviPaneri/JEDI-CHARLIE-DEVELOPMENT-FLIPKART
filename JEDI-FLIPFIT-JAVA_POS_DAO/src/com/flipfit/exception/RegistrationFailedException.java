package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationFailedException.
 * Custom exception thrown when user registration fails.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class RegistrationFailedException extends Exception {

    /**
     * Instantiates a new registration failed exception.
     */
    public RegistrationFailedException() {
        super("Registration failed. Please try again.");
    }

    /**
     * Instantiates a new registration failed exception with custom message.
     *
     * @param message the detail message
     */
    public RegistrationFailedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new registration failed exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public RegistrationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
