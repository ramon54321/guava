package guava.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/submission")
public class Submission {
    @GET
    public String getAllSubmissions() {
	return "Version 2";
    }
}
