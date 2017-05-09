package guava.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/assignment")
public class Assignment {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAssignments() {
    	ArrayList<guava.model.Assignment> a = new ArrayList<>();
    	a.add(new guava.model.Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5));
    	a.add(new guava.model.Assignment(2, 2, 3, "2017-06-02", "Exercise 2", "", 5));
    	a.add(new guava.model.Assignment(3, 2, 3, "2017-06-03", "Exercise 3", "", 5));
    	return Response.ok(a).build();
    }
}
