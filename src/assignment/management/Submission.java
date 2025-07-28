/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.management;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author h
 */
public class Submission {

     private final SimpleStringProperty assignmentId;
    private final SimpleStringProperty teacherEmail;
    private final SimpleStringProperty studentEmail;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty submittedFilePath;
    private final SimpleStringProperty submittedAt;
    private final SimpleDoubleProperty mark;
    private final SimpleStringProperty feedback;

    public Submission(String assignmentId, String teacherEmail, String studentEmail, String studentName, String submittedFilePath, String submittedAt) {
        this.assignmentId = new SimpleStringProperty(assignmentId);
        this.teacherEmail = new SimpleStringProperty(teacherEmail);
        this.studentEmail = new SimpleStringProperty(studentEmail);
        this.studentName = new SimpleStringProperty(studentName);
        this.submittedFilePath = new SimpleStringProperty(submittedFilePath);
        this.submittedAt = new SimpleStringProperty(submittedAt);
        this.mark = new SimpleDoubleProperty(-1);  // -1 means unmarked
        this.feedback = new SimpleStringProperty("");
    }

    // Getters
    public String getAssignmentId() {
        return assignmentId.get();
    }

    public String getTeacherEmail() {
        return teacherEmail.get();
    }

    public String getStudentEmail() {
        return studentEmail.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public String getSubmittedFilePath() {
        return submittedFilePath.get();
    }

    public String getSubmittedAt() {
        return submittedAt.get();
    }

    public double getMark() {
        return mark.get();
    }

    public String getFeedback() {
        return feedback.get();
    }

    // Setters
    public void setMark(double mark) {
        this.mark.set(mark);
    }

    public void setFeedback(String feedback) {
        this.feedback.set(feedback);
    }
}
