package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Role;

import java.util.UUID;

public class CustomerService implements CustomerInterface {
    @Override
    public  void registerCustomer(String name, String email , String phoneNumber, String password) {
        // Logic: Validate email format, check if user exists


        Customer customer=new Customer();
        customer.setUserId(UUID.randomUUID().toString());
        customer.setCustomerId(UUID.randomUUID().toString());
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        //create hash of password and save hash
        customer.setPasswordHash(password);


        Role role =new Role();
        //set role id and role des and role name
        role.setRoleName("Customer");
        customer.setRole(role);


        // DAO: customerDao.save(customer);

        System.out.println("Customer registered: " + customer.getName());

    }

    @Override
    public boolean login(String email, String password) {
        // Logic: Verify credentials
        return true;
    }

    @Override
    public void editProfile(Customer customer) {
        // DAO: update customer set ...
    }
}