package com.Flipfit.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class LandingController {

    @GET
    public Response getLandingPage() {
        return Response.ok("Welcome to FlipFit! Please use the /login endpoint with 'role', 'email', and 'password' query parameters.")
                .build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response loginAndRedirect(
            @FormParam("role") String role,
            @FormParam("email") String email,
            @FormParam("password") String password) {

        // Basic routing logic based on user input
        String redirectPath;

        switch (role.toLowerCase()) {
            case "admin":
                redirectPath = "/admin/pending-gyms";
                break;
            case "customer":
                redirectPath = "/customer/list-customers";
                break;
            case "gymowner":
                redirectPath = "/gym-owner/register";
                break;
            default:
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid role selected. Choose: admin, customer, or gymowner.")
                        .build();
        }

        // In a real app, you would verify credentials here using your services
        return Response.seeOther(URI.create(redirectPath)).build();
    }
}