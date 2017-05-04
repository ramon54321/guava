package guava.tests;

import guava.Assignment;
import org.junit.Test;
import static org.junit.Assert.*;

public class AssignmentTest {

    @Test
    public void testConstructor() {
	Assignment a = new Assignment(1, 2, 3, "2017-06-01", "Exercise 1", "", 5);
	assertEquals(1, a.getId());
    }
}
