package com.flipkart.business;

import com.flipkart.bean.Customer;
import java.util.List;

public interface CustomerInterface {
    void registerCustomer(String name, String email , String phoneNumber, String password);
    boolean login(String email, String password);
    void editProfile(Customer customer);
}