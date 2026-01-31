package com.flipfit.exception;

/**
 * The Class ResourceNotFoundException.
 * Custom exception thrown when a requested resource (User, Gym, Slot, etc.) is not found.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Instantiates a new resource not found exception.
     */
    public ResourceNotFoundException() {
        super("The requested resource could not be found in the system.");
    }

    /**
     * Instantiates a new resource not found exception with custom message.
     *
     * @param message the detail message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new resource not found exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}