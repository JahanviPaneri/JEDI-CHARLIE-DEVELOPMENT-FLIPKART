package com.flipkart.dao;

import com.flipkart.bean.Customer;
import java.util.List;

public interface CustomerDaoInterface {
    /**
     * Adds a new customer to the system (Registration)
     * @param customer The customer object to be stored
     */
    void addCustomer(Customer customer);

    /**
     * Retrieves a customer by their unique ID
     * @param customerId Unique ID of the customer
     * @return Customer object if found, else null
     */
    Customer getCustomerById(String customerId);

    /**
     * Retrieves a customer by their email (Useful for Login)
     * @param email The registered email address
     * @return Customer object if found, else null
     */
    Customer getCustomerByEmail(String email);

    /**
     * Returns all registered customers
     * @return List of all Customer objects
     */
    List<Customer> getAllCustomers();
}