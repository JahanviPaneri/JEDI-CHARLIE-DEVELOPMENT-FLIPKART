package com.Flipfit.rest;


import com.Flipfit.bean.Customer;
import com.Flipfit.buisness.CustomerInterface;
import com.Flipfit.buisness.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {
    private final CustomerInterface customerService = new CustomerService();

    @POST
    @Path("/register")
    public Response registerCustomer(Customer customer) {
        customerService.registerCustomer(
                customer.getName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getPasswordHash()
        );
        return Response.status(Response.Status.CREATED).entity("Customer registered successfully").build();
    }

    @POST
    @Path("/login")
    public Response login(@QueryParam("email") String email, @QueryParam("password") String password) {
        boolean isAuthenticated = customerService.login(email, password);
        if (isAuthenticated) {
            return Response.ok("Login successful").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
    }

    @GET
    @Path("/list-customers")
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }
}
