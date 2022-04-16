package dev.breus.webapp.resources;

import dev.breus.webapp.model.Greeting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/greet/{name}")
    public Greeting greet(@PathParam("name") String name) {
        return new Greeting(name, "Hello there!");
    }
}
