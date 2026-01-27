package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ApprovalPendingException.
 * Custom exception thrown when an approval is pending for gym/owner registration.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class ApprovalPendingException extends Exception {

    /**
     * Instantiates a new approval pending exception.
     */
    public ApprovalPendingException() {
        super("Approval is pending. Please wait for admin approval.");
    }

    /**
     * Instantiates a new approval pending exception with custom message.
     *
     * @param message the detail message
     */
    public ApprovalPendingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new approval pending exception with message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public ApprovalPendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
