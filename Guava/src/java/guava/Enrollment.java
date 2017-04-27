/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guava;

/**
 *
 * @author Hannu
 */
public class Enrollment {

    private int id;
    private int courseId;
    private int userId;
    
    public Enrollment() {
        
    }
    
    public Enrollment(int id, int courseId, int userId) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
    }
    
     public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseid) {
        this.courseId = courseid;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getId() {
        return this.id;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public int getUserId() {
        return this.userId;
    }
    
    public String toString() {
        return "ID: " + this.id + " --- Course ID: " + this.courseId + " --- User ID: " + this.userId;
    }

}
