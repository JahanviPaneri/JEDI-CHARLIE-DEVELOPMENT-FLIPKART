package com.Flipfit.rest;

import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;
import com.Flipfit.buisness.GymOwnerInterface;
import com.Flipfit.buisness.GymOwnerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/gym-owner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymOwnerController {

    private final GymOwnerInterface gymOwnerService = new GymOwnerService();

    @POST
    @Path("/register")
    public Response registerOwner(GymOwner owner) {
        gymOwnerService.registerOwner(
                owner.getName(),
                owner.getEmail(),
                owner.getPhoneNumber(),
                owner.getPasswordHash()
        );
        return Response.status(Response.Status.CREATED).entity("Gym Owner registration request sent").build();
    }

    @POST
    @Path("/add-gym")
    public Response requestGymAddition(GymCenter gym) {
        gymOwnerService.requestGymAddition(gym);
        return Response.ok("Gym addition request submitted").build();
    }

    @GET
    @Path("/{ownerId}/gyms")
    public List<GymCenter> viewMyGyms(@PathParam("ownerId") String ownerId) {
        return gymOwnerService.viewMyGyms(ownerId);
    }
}