package com.Flipfit.rest;


import com.Flipfit.bean.GymCenter;
import com.Flipfit.bean.GymOwner;
import com.Flipfit.buisness.AdminInterface;
import com.Flipfit.buisness.AdminService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {
    private final AdminInterface adminService = new AdminService();

    @POST
    @Path("/approve-gym/{gymId}")
    public Response approveGymCenter(@PathParam("gymId") String gymId) {
        adminService.approveGymCenter(gymId);
        return Response.ok("Gym Center Approved successfully").build();
    }

    @POST
    @Path("/approve-owner/{ownerId}")
    public Response approveGymOwner(@PathParam("ownerId") String ownerId) {
        adminService.approveGymOwner(ownerId);
        return Response.ok("Gym Owner Approved successfully").build();
    }

    @GET
    @Path("/pending-gyms")
    public List<GymCenter> viewPendingGyms() {
        return adminService.viewPendingGyms();
    }

    @GET
    @Path("/pending-owners")
    public List<GymOwner> viewPendingOwners() {
        return adminService.viewPendingOwners();
    }
}
