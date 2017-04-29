/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeSet;

/**
 *
 * @author Hannu
 */
public class TreeSets implements Serializable {

    private TreeSet<User> ts;

    public TreeSets() {
        ts = new TreeSet<User>();
    }

    //serialize and save
    public static void save(Object obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
        System.out.println("saved!");
    }

    //load and deserialize
    public static Object load(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    public void add(User user) {
        ts.add(user);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        TreeSets t = new TreeSets();

        
        //Here happens the saving
        /*
        User u1 = new User(1, "Kekez Rosberg", "ruba", false);
        User u2 = new User(2, "Urhoo Kekkonen", "keke", true);
        t.add(u1);
        t.add(u2);
        save(t, "newfile");
         */
        
        //Here happens the loading
        t = (TreeSets) load("newfile");

        for (User user : t.ts) {
            System.out.println(user);
        }

    }

}
