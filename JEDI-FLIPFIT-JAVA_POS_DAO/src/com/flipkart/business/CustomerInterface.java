package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipfit.exception.RegistrationFailedException;
import com.flipfit.exception.InvalidCredentialsException;
import com.flipfit.exception.UserNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomerInterface.
 * Defines business operations for customer management.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public interface CustomerInterface {
    
    /**
     * Register customer.
     *
     * @param name the customer name
     * @param email the customer email
     * @param phoneNumber the phone number
     * @param password the password
     * @throws RegistrationFailedException the registration failed exception
     */
    void registerCustomer(String name, String email, String phoneNumber, String password) throws RegistrationFailedException;
    
    /**
     * Login.
     *
     * @param email the email
     * @param password the password
     * @return true, if successful
     * @throws InvalidCredentialsException the invalid credentials exception
     */
    boolean login(String email, String password) throws InvalidCredentialsException;
    
    /**
     * Edits the profile.
     *
     * @param customer the customer
     * @throws UserNotFoundException the user not found exception
     */
    void editProfile(Customer customer) throws UserNotFoundException;
}