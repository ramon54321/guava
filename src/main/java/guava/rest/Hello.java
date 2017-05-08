package guava.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class Hello {
    @GET
    public String message() {
	return "6th hello!";
    }
}
