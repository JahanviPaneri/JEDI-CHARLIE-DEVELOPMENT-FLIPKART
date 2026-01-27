package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Role;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDaoImpl;
import com.flipkart.dao.CustomerDaoInterface;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.dao.UserDaoInterface;
import com.flipfit.exception.RegistrationFailedException;
import com.flipfit.exception.InvalidCredentialsException;
import com.flipfit.exception.UserNotFoundException;

import java.util.UUID;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerService.
 * Business layer implementation for customer-related operations.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class CustomerService implements CustomerInterface {

    /** The customer dao. */
    private CustomerDaoInterface customerDao = new CustomerDaoImpl();

    /**
     * Register customer.
     * Registers a new customer in the system after validation.
     *
     * @param name the customer name
     * @param email the customer email
     * @param phoneNumber the customer phone number
     * @param password the customer password
     * @throws RegistrationFailedException if registration fails due to duplicate email or database error
     */
    @Override
    public void registerCustomer(String name, String email, String phoneNumber, String password) throws RegistrationFailedException {
        try {
            // Business Logic: Check if customer already exists
            if (customerDao.getCustomerByEmail(email) != null) {
                throw new RegistrationFailedException("Email " + email + " is already registered.");
            }

            Role customerRole = new Role();
            customerRole.setRoleName("Customer");

            Customer customer = new Customer();
            customer.setCustomerId(UUID.randomUUID().toString());
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhoneNumber(phoneNumber);
            customer.setPasswordHash(password);

            User user = new User();
            user.setUserId(UUID.randomUUID().toString());
            user.setName(name);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setPasswordHash(password);
            user.setRole(customerRole);

            // DAO Call: Save to MySQL database
            UserDaoInterface userDao = new UserDaoImpl();
            userDao.addUser(user);
            customerDao.addCustomer(customer);

            System.out.println("Business: Customer registration processed for " + customer.getName());
        } catch (Exception e) {
            throw new RegistrationFailedException("Registration failed: " + e.getMessage(), e);
        }
    }

    /**
     * Login.
     * Validates customer credentials and performs login.
     *
     * @param email the customer email
     * @param password the customer password
     * @return true if login successful, false otherwise
     * @throws InvalidCredentialsException if email or password is invalid
     */
    @Override
    public boolean login(String email, String password) throws InvalidCredentialsException {
        try {
            // Business Logic: Retrieve from DB and verify credentials
            Customer customer = customerDao.getCustomerByEmail(email);

            if (customer == null) {
                throw new InvalidCredentialsException("Invalid email or password.");
            }

            if (!customer.getPasswordHash().equals(password)) {
                throw new InvalidCredentialsException("Invalid email or password.");
            }

            System.out.println("Login successful for: " + email);
            return true;
        } catch (InvalidCredentialsException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidCredentialsException("Login failed: " + e.getMessage(), e);
        }
    }

    /**
     * Edits the profile.
     * Updates customer profile information.
     *
     * @param customer the customer object with updated information
     * @throws UserNotFoundException if customer is not found in the system
     */
    @Override
    public void editProfile(Customer customer) throws UserNotFoundException {
        try {
            // Business Logic: Check if customer exists
            Customer existingCustomer = customerDao.getCustomerById(customer.getCustomerId());
            if (existingCustomer == null) {
                throw new UserNotFoundException("Customer with ID " + customer.getCustomerId() + " not found.");
            }

            System.out.println("Updating profile for ID: " + customer.getCustomerId());
            // Note: Add updateCustomer method to DAO interface for full implementation
        } catch (UserNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new UserNotFoundException("Profile update failed: " + e.getMessage(), e);
        }
    }
}