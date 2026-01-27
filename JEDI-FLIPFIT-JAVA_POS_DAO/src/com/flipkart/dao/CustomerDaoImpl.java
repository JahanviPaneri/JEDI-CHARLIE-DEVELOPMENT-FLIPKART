package com.flipkart.dao;

import com.flipkart.bean.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDaoImpl implements CustomerDaoInterface {

    // Key: customerId (String), Value: Customer Object
    // Static ensures the data stays in memory as long as the app is running
    private static final Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
        System.out.println("DAO: Customer registered successfully with ID: " + customer.getCustomerId());
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        // Since the map key is ID, we stream values to find the email match
        return customerMap.values().stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        // Return a new list to avoid external modification of the internal map
        return new ArrayList<>(customerMap.values());
    }
}