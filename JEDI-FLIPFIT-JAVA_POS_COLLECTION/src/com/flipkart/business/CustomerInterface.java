package com.flipfit.business;

import com.flipfit.bean.Customer;
import java.util.List;

public interface CustomerInterface {
    void registerCustomer(String name, String email , String phoneNumber, String password);
    boolean login(String email, String password);
    void editProfile(Customer customer);
}