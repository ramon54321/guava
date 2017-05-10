package guava.rest;

import guava.DataStore;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/submission")
public class Submission {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSubmissions() {
	return Response.ok(DataStore.get().getSubmissions()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSubmission(guava.model.Submission submission, @Context HttpServletRequest request) {
	DataStore.get().addSubmission(submission);
	return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/grade/{value}")
    public Response gradeSubmission(@PathParam("id") String id, @PathParam("value") String value, @Context HttpServletRequest request) {
	return Response.ok().build();
    }
}
