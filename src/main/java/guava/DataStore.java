package guava;

import guava.model.Assignment;
import guava.model.Submission;
import java.util.ArrayList;

public class DataStore {
    
    private static DataStore instance;
    private ArrayList<Assignment> assignments;
    private ArrayList<Submission> submissions;
    
    private DataStore() {
    	assignments = new ArrayList<>();
    	assignments.add(new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5));
    	assignments.add(new Assignment(2, 2, 3, "2017-06-02", "Exercise 2", "", 5));
    	assignments.add(new Assignment(3, 2, 3, "2017-06-03", "Exercise 3", "", 5));
    	assignments.add(new Assignment(4, 2, 3, "2017-06-04", "Exercise 4", "", 5));
	
	submissions = new ArrayList<>();
	submissions.add(new Submission(1, 1, 1, "Some answer", "2017-06-01", 3, ""));
    }
    
    public static DataStore get() {
	if (instance == null) {
	    instance = new DataStore();
	}
	return instance;
    }
    
    public ArrayList<Assignment> getAssignments() {
	return assignments;
    }
    
    public void addAssignment(Assignment a) {
	assignments.add(a);
    }
    
    public ArrayList<Submission> getSubmissions() {
	return submissions;
    }
    
    public void addSubmission(Submission s) {
	submissions.add(s);
    }
}
