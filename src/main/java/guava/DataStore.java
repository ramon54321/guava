package guava;

import guava.model.Course;

public class DataStore {
    
    private final BSTree<Course> courses;
    
    public DataStore() {
        courses = new BSTree<>();
    }
    
    public void getCourseBSTree() {
    }
}
