package com.example.demos;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/todos")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class TodoResource {

    @Inject
    Logger logger;

    @POST
    @Transactional
    public Response createTodo(Todo todo, @Context UriInfo uriInfo) {
        logger.info("Creating todo: " + todo);
        Todo.persist(todo);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(todo.id.toString());
        return Response.created(uriBuilder.build()).entity(todo).build();
    }

    @GET
    public List<Todo> getTodos() {
        logger.info("Getting all todos");
        return Todo.listAll();
    }
}