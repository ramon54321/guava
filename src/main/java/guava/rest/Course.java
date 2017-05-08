package guava.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/course")
public class Course {
    @GET
    public String getAllCourses() {
	return "Version 1";
    }
}
