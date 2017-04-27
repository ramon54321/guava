package guava;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/resources")
public class RestResources {
    
    private User u1;
    private Assignment a1;
    private Assignment a2;
    private ArrayList<Assignment> list;
    
    public RestResources() {
        this.list = new ArrayList<>();
        this.u1 = new User(1, "Keke Rosberg", "ruba", false); 
        this.a1 = new Assignment(1, 2, 3, "24.4.2017", "Java exercise 5b", "Create a calculator", 5);
        this.a2 = new Assignment(4, 5, 6, "30.5.2018", "C++ practise", "Do something fun with C++", 10);
        list.add(a1);
        list.add(a2);
    }
    
    @GET
    public String getCourses() {
	return "hello";
        
    }
    
    @Path("/assignments")
    @GET
    public String assignments() {
        String stuff = "";
        for (Assignment a : list) {
            stuff += a;
        }
        return stuff;
    }
    
}
