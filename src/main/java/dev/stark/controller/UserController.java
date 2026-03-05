package dev.stark.controller;

import dev.stark.entity.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    public List<User> getUsers() {
        return User.listAll();
    }

    @POST
    @Transactional
    public void createUser(User user) {
        user.persist();
    }
}