package com.flipfit.exception;

/**
 * The Class LoginFailedException.
 * Custom exception thrown when a login attempt fails due to system or user issues.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class LoginFailedException extends RuntimeException {

    /**
     * Instantiates a new login failed exception.
     */
    public LoginFailedException() {
        super("Login failed. Please check your credentials or contact the administrator.");
    }

    /**
     * Instantiates a new login failed exception with custom message.
     *
     * @param message the detail message
     */
    public LoginFailedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new login failed exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}