/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guava.tests;

import guava.model.Course;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Hannu
 */
public class CourseTest {

    @Test
    public void testId() {
        Course a = new Course(2, "Math");
        assertEquals(2, a.getId());
    }
    
    @Test
    public void testTitle() {
        Course a = new Course(2, "Physics");
        assertEquals("Physics", a.getTitle());
    }
    
    @Test
    public void testSetId() {
        Course a = new Course(2, "Math");
        a.setId(3);
        assertEquals(3, a.getId());
    }
    
    @Test
    public void testCompareTo() {
        Course a = new Course(2, "Math");
        Course b = new Course(3, "Physics");
        assertEquals(-1, a.compareTo(b));
    }

}
