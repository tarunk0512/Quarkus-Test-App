package dev.stark.controller;

import dev.stark.dto.UserRequest;
import dev.stark.dto.UserResponse;
import dev.stark.service.UserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<UserResponse> getUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public UserResponse getUser(@PathParam("id") Long id) {
        return userService.getUser(id);
    }

    @POST
    public Response createUser(@Valid UserRequest request) {

        UserResponse response = userService.createUser(request);

        return Response
                .status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @PUT
    @Path("/{id}")
    public UserResponse updateUser(
            @PathParam("id") Long id,
            @Valid UserRequest request
    ) {

        return userService.updateUser(id, request);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {

        userService.deleteUser(id);

        return Response.noContent().build();
    }
}