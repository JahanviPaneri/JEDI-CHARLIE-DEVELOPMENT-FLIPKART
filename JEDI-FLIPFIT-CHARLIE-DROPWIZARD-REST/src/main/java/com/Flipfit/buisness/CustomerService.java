package com.Flipfit.buisness;

import com.Flipfit.bean.Customer;
import com.Flipfit.bean.Role;
import com.Flipfit.bean.User;
import com.Flipfit.dao.CustomerDaoImpl;
import com.Flipfit.dao.CustomerDaoInterface;
import com.Flipfit.dao.UserDaoImpl;
import com.Flipfit.dao.UserDaoInterface;

import java.util.UUID;

public class CustomerService implements CustomerInterface {
    private CustomerDaoInterface customerDao = new CustomerDaoImpl();
    private UserDaoInterface userDao = new UserDaoImpl();

    @Override
    public void registerCustomer(String name, String email, String phoneNumber, String password) {
        if (customerDao.getCustomerByEmail(email) != null) {
            System.out.println("Registration Failed: Email " + email + " already registered.");
            return;
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

        userDao.addUser(user);
        customerDao.addCustomer(customer);
        System.out.println("Business: Customer registration processed for " + customer.getName());
    }

    @Override
    public boolean login(String email, String password) {
        Customer customer = customerDao.getCustomerByEmail(email);
        if (customer != null && customer.getPasswordHash().equals(password)) {
            System.out.println("Login successful for: " + email);
            return true;
        }
        System.out.println("Invalid email or password.");
        return false;
    }

    @Override
    public void editProfile(Customer customer) {
        System.out.println("Updating profile for ID: " + customer.getCustomerId());
    }
}