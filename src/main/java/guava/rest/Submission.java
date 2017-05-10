package guava.rest;

import java.util.ArrayList;
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
	ArrayList<guava.model.Submission> a = new ArrayList<>();
	a.add(new guava.model.Submission(1, 1, 1, "Some answer", "2017-06-01", 3, ""));
	return Response.ok(a).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSubmission(Submission submission, @Context HttpServletRequest request) {
	return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/grade/{value}")
    public Response gradeSubmission(@PathParam("id") String id, @PathParam("value") String value, @Context HttpServletRequest request) {
	return Response.ok().build();
    }
}
