package guava.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/assignment")
public class Assignment {
    @GET
    public String getAllAssignments() {
	return "Version 3";
    }
}
