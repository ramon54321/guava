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
public class Course {
    
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
    
}
