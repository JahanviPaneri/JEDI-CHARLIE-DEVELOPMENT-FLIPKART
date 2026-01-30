package com.flipfit.exception;

/**
 * The Class IncorrectCredentialsException.
 * Custom exception thrown when login credentials (username/password) are invalid.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class IncorrectCredentialsException extends RuntimeException {

    /**
     * Instantiates a new incorrect credentials exception.
     */
    public IncorrectCredentialsException() {
        super("Invalid username or password. Please try again.");
    }

    /**
     * Instantiates a new incorrect credentials exception with custom message.
     *
     * @param message the detail message
     */
    public IncorrectCredentialsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new incorrect credentials exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public IncorrectCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}