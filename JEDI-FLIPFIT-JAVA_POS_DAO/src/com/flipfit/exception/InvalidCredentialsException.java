package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidCredentialsException.
 * Custom exception thrown when user provides invalid login credentials.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class InvalidCredentialsException extends Exception {

    /**
     * Instantiates a new invalid credentials exception.
     */
    public InvalidCredentialsException() {
        super("Invalid email or password. Please try again.");
    }

    /**
     * Instantiates a new invalid credentials exception with custom message.
     *
     * @param message the detail message
     */
    public InvalidCredentialsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new invalid credentials exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
