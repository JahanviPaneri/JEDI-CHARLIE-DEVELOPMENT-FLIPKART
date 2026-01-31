package com.flipfit.exception;

/**
 * The Class InvalidChoiceException.
 * Custom exception thrown when a user selects an invalid option in the menu.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class InvalidChoiceException extends RuntimeException {

    /**
     * Instantiates a new invalid choice exception.
     */
    public InvalidChoiceException() {
        super("Invalid selection. Please choose a valid option from the menu.");
    }

    /**
     * Instantiates a new invalid choice exception with custom message.
     *
     * @param message the detail message
     */
    public InvalidChoiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new invalid choice exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidChoiceException(String message, Throwable cause) {
        super(message, cause);
    }
}