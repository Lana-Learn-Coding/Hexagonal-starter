package com.example.domain.user.application;

import com.example.domain.user.core.model.*;
import com.example.domain.user.core.ports.incoming.*;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final CreateUser addNewUser;
    private final DeleteUser deleteUser;
    private final CheckUserExist checkUserExist;
    private final UpdateUser updateUser;
    private final FindOneUser findOneUser;
    private final FindAllUser findAllUser;

    @GET
    public List<User> fetchAllUser() {
        return findAllUser.handle(new FindAllUserCommand());
    }

    @GET
    @Path("/{id}")
    public Response fetchUser(@PathParam("id") UUID id) {
        return findOneUser
            .handle(new FindOneUserCommand(id))
            .map(u -> Response.ok(u).build())
            .orElse(Response.status(404).build());
    }

    // Body automatically bind to first un-annotated parameter
    // It can be of any type: String, Object,... or models
    @POST
    public Response createUser(@Valid CreateUserCommand createUserCommand) {
        return addNewUser.handle(createUserCommand)
            .map(saved -> Response.status(201).entity(saved).build())
            .orElse(Response.status(400).build());
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") UUID id, @Valid UpdateUserCommand updateUserCommand) {
        CheckUserExistCommand checkUserExistCommand = new CheckUserExistCommand();
        checkUserExistCommand.setUserId(id);
        updateUserCommand.setId(id);
        if (!checkUserExist.handle(checkUserExistCommand)) {
            return Response.status(404).build();
        }
        return updateUser.handle(updateUserCommand)
            .map(updated -> Response.ok(updated).build())
            .orElse(Response.status(400).build());
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") UUID id) {
        DeleteUserCommand command = new DeleteUserCommand();
        command.setUserId(id);
        deleteUser.handle(command);
        return Response.status(200).build();
    }
}