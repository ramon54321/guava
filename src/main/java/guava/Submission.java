package guava;

public class Submission {
    
    private int id;
    private int assignmentId;
    private int studentUserId;
    private String answer;
    private String submittedDate;
    private int grade;
    private String comment;
    
    public Submission() {
    }
    
    public Submission(int id, int assignmentId, int studentUserId, String answer, String submittedDate, int grade, String comment) {
        this.id = id;
        this.assignmentId = assignmentId;
        this.studentUserId = studentUserId;
        this.answer = answer;
        this.submittedDate = submittedDate;
        this.grade = grade;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public int getStudentUserId() {
        return studentUserId;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public int getGrade() {
        return grade;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setStudentUserId(int studentUserId) {
        this.studentUserId = studentUserId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
