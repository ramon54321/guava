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
public class Assignment {

    private int id;
    private int courseId;
    private int teacherUserId;
    private String deadline;
    private String title;
    private String description;
    private int maxGrade;

    public Assignment() {

    }

    public Assignment(int id, int courseId, int teacherUserId, String deadline, String title, String description, int maxGrade) {
        this.id = id;
        this.courseId = courseId;
        this.teacherUserId = teacherUserId;
        this.deadline = deadline;
        this.title = title;
        this.description = description;
        this.maxGrade = maxGrade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseid) {
        this.courseId = courseid;
    }

    public void setTeacherUserId(int teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxGrade(int maxGrade) {
        this.maxGrade = maxGrade;
    }

    public int getId() {
        return this.id;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public int getTeacherUserId() {
        return this.teacherUserId;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getMaxGrade() {
        return this.maxGrade;
    }

    public String toString() {
        return "ID: " + this.id + " --- Course ID: " + this.courseId + " --- TeacherUserID: " + this.teacherUserId + 
                " --- Deadline: " + this.deadline + " --- Title: " + this.title + " --- Description: " + this.description + " --- Max Grade: " + this.maxGrade;
    }

}
