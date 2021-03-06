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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getSubmission(@PathParam("id") String id) {
	return Response.ok(DataStore.get().getSubmission(Integer.parseInt(id))).build();
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
	DataStore.get().getSubmission(Integer.parseInt(id)).setGrade(Integer.parseInt(value));
	return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findByStudent/{assignmentId}/{studentId}")
    public Response findByStudent(@PathParam("assignmentId") String assignmentId, @PathParam("studentId") String studentId, @Context HttpServletRequest request) {
	return Response.ok(DataStore.get().findSubmissionByStudent(Integer.parseInt(assignmentId), Integer.parseInt(studentId))).build();
    }
}
