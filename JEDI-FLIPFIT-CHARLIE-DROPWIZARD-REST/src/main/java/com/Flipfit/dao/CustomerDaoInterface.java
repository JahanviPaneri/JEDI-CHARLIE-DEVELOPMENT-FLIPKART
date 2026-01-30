package com.Flipfit.dao;

import com.Flipfit.bean.Customer;

import java.util.List;

public interface CustomerDaoInterface {
    void addCustomer(Customer customer);
    Customer getCustomerByEmail(String email);
    List<Customer> listCustomers();
}