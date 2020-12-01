/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1assignment7;

/**
 *
 * @author Devrin Aiden Tiongson
 */
public class Course {
    private String courseName;
    private double credit;
    private double examScore;
    private double assignmentScore;
    
    /**
     * default constructor
     */
    public Course() {
        this.courseName = null;
        this.credit = 0;
        this.examScore = 0;
        this.assignmentScore = 0;
    }
    
    /**
     * constructor with course name and course credit
     * @param courseName course name
     * @param credit course credit
     */
    public Course(String courseName, double credit) {
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = 0;
        this.assignmentScore = 0;
    }
    
    /**
     * full constructor for a course
     * @param courseName course name
     * @param credit course credit
     * @param examScore course exam score
     * @param assignmentScore course assignment score
     */
    public Course(String courseName, double credit, 
            double examScore, double assignmentScore) {
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = examScore;
        this.assignmentScore = assignmentScore;
    }
    
    /**
     * clone constructor
     * @param other Course to clone data from
     */
    public Course(Course other) {
        this.courseName = other.courseName;
        this.credit = other.credit;
        this.examScore = other.examScore;
        this.assignmentScore = other.assignmentScore;
    }
    
    /**
     * calculates the course's final score (exams 60%, assignments 40%)
     * @return course final score
     */
    public double calcFinalScore() {
        double examWeight = 0.6;
        double assignWeight = 0.4;
        return examScore * examWeight + assignmentScore * assignWeight;
    }
    
    /**
     * checks is the course score is enough to pass
     * @return true if passing, false if not
     */
    public boolean isPassed() {
        double passScore = 60;
        return (calcFinalScore() >= passScore);
    }
    
    public boolean equals(Course other) {
        return this.courseName.equals(other.courseName) &&
                this.credit == other.credit &&
                this.examScore == other.examScore &&
                this.assignmentScore == other.assignmentScore;
    }

    @Override
    public String toString() {
        String out = "";
        out += String.format("%-25s: %s\n", "Course Name", courseName);
        out += String.format("%-25s: %.1f\n", "Credit", credit);
        out += String.format("%-25s: %.1f\n", "Exam Score", examScore);
        out += String.format("%-25s: %.1f\n",
                "Assignment Score", assignmentScore);
        out += String.format("%-25s: %.1f\n", "Final Score", calcFinalScore());
        return out;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }
}
