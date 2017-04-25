package guava;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/courses")
public class Course {
    
    @GET
    public String getCourses() {
	return "hello";
    }
    
}
