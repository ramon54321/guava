package guava;

import guava.model.Assignment;
import guava.model.Submission;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.TreeMap;

public class DataStore {
    
    private static DataStore instance;
    private TreeMap<Integer, Assignment> assignments;
    private TreeMap<Integer, Submission> submissions;
    
    private DataStore() {
	assignments = readFromFile("guava.assignments.dat");
	submissions = readFromFile("guava.submissions.dat");
    }
    
    public static DataStore get() {
	if (instance == null) {
	    instance = new DataStore();
	}
	return instance;
    }

    private <T> TreeMap<Integer, T> readFromFile(String fileName) {
	try {
	    FileInputStream fs = new FileInputStream(fileName);
	    ObjectInputStream os = new ObjectInputStream(fs);
	    return (TreeMap<Integer, T>)os.readObject();
	} catch (Exception ex) {
	    return new TreeMap<Integer, T>();
	}
    }
    
    private void writeToFile(String fileName, Object o) {
	try {
	    FileOutputStream fs = new FileOutputStream(fileName);
	    ObjectOutputStream os = new ObjectOutputStream(fs);
	    os.writeObject(o);
	    os.flush();
	} catch (Exception ex) {
	}
    }
    
    public Collection<Assignment> getAssignments() {
	return assignments.values();
    }
    
    public Assignment getAssignment(int id) {
	return assignments.get(id);
    }
    
    public void addAssignment(Assignment a) {
	assignments.put(a.getId(), a);
	writeToFile("guava.assignments.dat", assignments);
    }
    
    public Collection<Submission> getSubmissions() {
	return submissions.values();
    }
    
    public Submission getSubmission(int id) {
	return submissions.get(id);
    }

    public Submission findSubmissionByStudent(int assignmentId, int studentId) {
	for (Submission s : submissions.values()) {
	    if (s.getAssignmentId() == assignmentId && s.getStudentUserId() == studentId) {
		return s;
	    }
	}
	return null;
    }
    
    public void addSubmission(Submission s) {
	submissions.put(s.getId(), s);
	writeToFile("guava.submissions.dat", submissions);
    }
}
