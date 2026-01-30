package com.Flipfit.bean;

public class Customer extends User{
    private String customerId;

//    String role ="Customer";

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
