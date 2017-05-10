package guava;

import guava.model.Assignment;
import guava.model.Submission;
import java.util.Collection;
import java.util.TreeMap;

public class DataStore {
    
    private static DataStore instance;
    private TreeMap<Integer, Assignment> assignments;
    private TreeMap<Integer, Submission> submissions;
    
    private DataStore() {
    	assignments = new TreeMap<>();
    	assignments.put(1, new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5));
    	assignments.put(2, new Assignment(2, 2, 3, "2017-06-02", "Exercise 2", "", 5));
    	assignments.put(3, new Assignment(3, 2, 3, "2017-06-03", "Exercise 3", "", 5));
	
	submissions = new TreeMap<>();
	submissions.put(1, new Submission(1, 1, 1, "Some answer", "2017-06-01", 3, ""));
    }
    
    public static DataStore get() {
	if (instance == null) {
	    instance = new DataStore();
	}
	return instance;
    }
    
    public Collection<Assignment> getAssignments() {
	return assignments.values();
    }
    
    public void addAssignment(Assignment a) {
	assignments.put(a.getId(), a);
    }
    
    public Collection<Submission> getSubmissions() {
	return submissions.values();
    }
    
    public void addSubmission(Submission s) {
	submissions.put(s.getId(), s);
    }
}
