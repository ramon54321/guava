package guava.model;

import java.io.Serializable;

public class Course implements Serializable, Comparable<Course>{
    
    private int id;
    private String title;
    
    public Course() {
    }
    
    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String toString() {
        return "ID: " + this.id + " --- Title: " + this.title;
    }

    @Override
    public int compareTo(Course course) {
        if (this.id > course.id) {
            return 1;
        }
        else if (this.id < course.id) {
            return -1;
        } 
        else {
            return 0;
        }
    }
}
