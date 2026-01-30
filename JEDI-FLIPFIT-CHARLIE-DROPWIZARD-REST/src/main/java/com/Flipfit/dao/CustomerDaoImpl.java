package com.Flipfit.dao;

import com.Flipfit.bean.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerDaoImpl implements CustomerDaoInterface {
    // Mock storage for demonstration; replace with JDBC SQL queries
    private static Map<String, Customer> customerDb = new HashMap<>();

    @Override
    public void addCustomer(Customer customer) {
        // SQL Logic: INSERT INTO Customer (customerId, name, email...) VALUES (?, ?, ?);
        customerDb.put(customer.getEmail(), customer);
        System.out.println("DAO: Customer record created for " + customer.getName());
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        // SQL Logic: SELECT * FROM Customer WHERE email = ?;
        return customerDb.get(email);
    }
}