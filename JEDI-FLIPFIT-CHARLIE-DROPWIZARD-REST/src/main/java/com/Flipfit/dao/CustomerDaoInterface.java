package com.Flipfit.dao;

import com.Flipfit.bean.Customer;

public interface CustomerDaoInterface {
    void addCustomer(Customer customer);
    Customer getCustomerByEmail(String email);
}