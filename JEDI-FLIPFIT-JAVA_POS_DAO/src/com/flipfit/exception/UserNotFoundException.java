package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 * Custom exception thrown when a user cannot be found in the system.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class UserNotFoundException extends Exception {

    /**
     * Instantiates a new user not found exception.
     */
    public UserNotFoundException() {
        super("User not found in the system.");
    }

    /**
     * Instantiates a new user not found exception with custom message.
     *
     * @param message the detail message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new user not found exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
