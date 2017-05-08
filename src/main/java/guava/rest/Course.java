package guava.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/course")
public class Course {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCourses() {
	ArrayList<guava.model.Course> a = new ArrayList<>();
	a.add(new guava.model.Course(1, "Finnish 1"));
	a.add(new guava.model.Course(2, "Finnish 2"));
	a.add(new guava.model.Course(3, "Finnish 3"));
	return Response.ok(a).build();
    }
}
