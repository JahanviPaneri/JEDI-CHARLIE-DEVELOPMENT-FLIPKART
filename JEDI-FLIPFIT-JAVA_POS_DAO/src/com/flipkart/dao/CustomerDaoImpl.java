//package com.flipkart.dao;
//
//import com.flipkart.bean.Customer;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CustomerDaoImpl implements CustomerDaoInterface {
//
//    // Key: customerId (String), Value: Customer Object
//    // Static ensures the data stays in memory as long as the app is running
//    private static final Map<String, Customer> customerMap = new HashMap<>();
//
//    @Override
//    public void addCustomer(Customer customer) {
//        customerMap.put(customer.getCustomerId(), customer);
//        System.out.println("DAO: Customer registered successfully with ID: " + customer.getCustomerId());
//    }
//
//    @Override
//    public Customer getCustomerById(String customerId) {
//        return customerMap.get(customerId);
//    }
//
//    @Override
//    public Customer getCustomerByEmail(String email) {
//        // Since the map key is ID, we stream values to find the email match
//        return customerMap.values().stream()
//                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        // Return a new list to avoid external modification of the internal map
//        return new ArrayList<>(customerMap.values());
//    }
//}
package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipfit.utils.DBConnection;
import com.flipfit.constant.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDaoImpl.
 * Implementation of CustomerDaoInterface providing database operations for Customer entities.
 *
 * @author FlipFit Development Team
 * @version 1.0
 */
public class CustomerDaoImpl implements CustomerDaoInterface {

    /**
     * Adds the customer to the database.
     *
     * @param customer the customer object to be added
     */
    @Override
    public void addCustomer(Customer customer) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.INSERT_CUSTOMER)) {

            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getPhoneNumber());
            pstmt.setString(5, customer.getPasswordHash());

            pstmt.executeUpdate();
            System.out.println("DAO: Customer registered successfully in DB with ID: " + customer.getCustomerId());
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets the customer by id.
     *
     * @param customerId the customer id
     * @return the customer object if found, null otherwise
     */
    @Override
    public Customer getCustomerById(String customerId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_CUSTOMER_BY_ID)) {

            pstmt.setString(1, customerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCustomer(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the customer by email.
     *
     * @param email the email address
     * @return the customer object if found, null otherwise
     */
    @Override
    public Customer getCustomerByEmail(String email) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_CUSTOMER_BY_EMAIL)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCustomer(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all customers from the database.
     *
     * @return the list of all customers
     */
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLConstants.SELECT_ALL_CUSTOMERS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                customers.add(mapResultSetToCustomer(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    /**
     * Map result set to customer.
     * Helper method to convert database result set to Customer bean.
     *
     * @param rs the result set from database query
     * @return the customer object
     * @throws SQLException the SQL exception
     */
    private Customer mapResultSetToCustomer(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getString("customerId"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        customer.setPhoneNumber(rs.getString("phoneNumber"));
        customer.setPasswordHash(rs.getString("password"));
        return customer;
    }
}
        customer.setEmail(rs.getString("email"));
        customer.setPhoneNumber(rs.getString("phoneNumber"));
        customer.setPasswordHash(rs.getString("password"));
        return customer;
    }
}