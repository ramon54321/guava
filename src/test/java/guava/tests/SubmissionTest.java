/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guava.tests;

import guava.model.Submission;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Hannu
 */
public class SubmissionTest {
    
    

    @Test
    public void testId() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"");
	assertEquals(1, a.getId());
    }

    @Test
    public void testAssignmentId() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"");
	assertEquals(2, a.getAssignmentId());
    }

    @Test
    public void testStudentUserId() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"");
	assertEquals(3, a.getStudentUserId());
    }

    @Test
    public void testAnswer() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"");
	assertEquals("Answer is 10", a.getAnswer());
    }

    @Test
    public void testSubmittedDate() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"");
	assertEquals("2017-06-01", a.getSubmittedDate());
    }
    
    @Test
    public void testGrade() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"");
	assertEquals(5, a.getGrade());
    }
    
    @Test
    public void testComment() {
	Submission a = new Submission(1, 2, 3, "Answer is 10", "2017-06-01", 5 ,"Excellent work");
	assertEquals("Excellent work", a.getComment());
    }
    
}
