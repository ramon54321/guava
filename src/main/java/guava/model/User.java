/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guava.model;

/**
 *
 * @author Hannu
 */
import java.io.Serializable;

public class User implements Serializable, Comparable<User> {
    
    private int id;
    private String name;
    private String password;
    private boolean isTeacher; //false = user is student
    
    public User() {
        
    }
    
    public User(int id, String name, String password, boolean teacher) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isTeacher = teacher;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setTeacher(boolean input) {
        this.isTeacher = input;
    }
    
    public int getId() {
        return this.id;
    }
        
    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public boolean getIsTeacher() {
        return this.isTeacher;
    }
    
    public String toString() {
        return "Id: " + this.id + ", Name: " + this.name + ", is teacher: " + this.isTeacher;
    }

    @Override
    public int compareTo(User user) {
        if (this.id > user.id) {
            return 1;
        }
        else if (this.id < user.id) {
            return -1;
        } 
        else {
            return 0;
        }
    }
    
}
