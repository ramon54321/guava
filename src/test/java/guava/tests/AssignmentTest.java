package guava.tests;

import guava.model.Assignment;
import org.junit.Test;
import static org.junit.Assert.*;

public class AssignmentTest {

    @Test
    public void testId() {
	Assignment a = new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5);
	assertEquals(1, a.getId());
    }

    @Test
    public void testCourseId() {
	Assignment a = new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5);
	assertEquals(2, a.getCourseId());
    }

    @Test
    public void testTeacherUserId() {
	Assignment a = new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5);
	assertEquals(3, a.getTeacherUserId());
    }

    @Test
    public void testDeadline() {
	Assignment a = new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5);
	assertEquals("2017-06-01", a.getDeadline());
    }

    @Test
    public void testTitle() {
	Assignment a = new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5);
	assertEquals("Exercise 1", a.getTitle());
    }
}
