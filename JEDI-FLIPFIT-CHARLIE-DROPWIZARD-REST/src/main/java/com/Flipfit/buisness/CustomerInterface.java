package com.Flipfit.buisness;

import com.Flipfit.bean.Customer;

import java.util.List;

public interface CustomerInterface {
    void registerCustomer(String name, String email, String phoneNumber, String password);
    boolean login(String email, String password);
    void editProfile(Customer customer);
    List<Customer> listCustomers();
}