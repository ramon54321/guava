package guava.rest;

import guava.DataStore;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/assignment")
public class Assignment {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAssignments() {
	return Response.ok(DataStore.get().getAssignments()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAssignment(guava.model.Assignment assignment, @Context HttpServletRequest request) {
	DataStore.get().addAssignment(assignment);
	return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getAssignment(@PathParam("id") String id) {
	return Response.ok(DataStore.get().getAssignment(Integer.parseInt(id))).build();
    }
}
