package com.flipfit.business;

import com.flipfit.bean.Customer;
import com.flipfit.exception.RegistrationFailedException;
import com.flipfit.exception.InvalidCredentialsException;
import com.flipfit.exception.UserNotFoundException;

/**
 * Interface for customer actions like joining, logging in, and profile updates.
 */
public interface CustomerInterface {

    // Create a new customer account in the system
    void registerCustomer(String name, String email, String phoneNumber, String password) throws RegistrationFailedException;

    // Verify customer identity to allow access to the app
    boolean login(String email, String password) throws InvalidCredentialsException;

    // Update existing customer details like name or contact info
    void editProfile(Customer customer) throws UserNotFoundException;
}