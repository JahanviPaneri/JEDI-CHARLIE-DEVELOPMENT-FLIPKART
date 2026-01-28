package com.flipfit.exception;

/**
 * The Class InvalidUserException.
 * Custom exception thrown when a user operation is invalid or the user state is incorrect.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class InvalidUserException extends RuntimeException {

    /**
     * Instantiates a new invalid user exception.
     */
    public InvalidUserException() {
        super("Invalid user operation or state. Access denied.");
    }

    /**
     * Instantiates a new invalid user exception with custom message.
     *
     * @param message the detail message
     */
    public InvalidUserException(String message) {
        super(message);
    }

    /**
     * Instantiates a new invalid user exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }
}