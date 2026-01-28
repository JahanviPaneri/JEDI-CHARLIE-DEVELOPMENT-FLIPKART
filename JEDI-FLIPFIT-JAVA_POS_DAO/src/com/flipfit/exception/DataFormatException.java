package com.flipfit.exception;

/**
 * The Class DataFormatException.
 * Custom exception thrown when input data does not match the required format.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class DataFormatException extends RuntimeException {

    /**
     * Instantiates a new data format exception.
     */
    public DataFormatException() {
        super("Invalid data format provided. Please check your input.");
    }

    /**
     * Instantiates a new data format exception with custom message.
     *
     * @param message the detail message
     */
    public DataFormatException(String message) {
        super(message);
    }

    /**
     * Instantiates a new data format exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}