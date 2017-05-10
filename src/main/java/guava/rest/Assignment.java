package guava.rest;

import guava.DataStore;
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
    	return Response.ok(DataStore.get().getAssignments()).build();
    }
}
