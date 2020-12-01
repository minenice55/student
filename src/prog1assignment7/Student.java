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
public class Student {
    public String name;
    public String gender;   //let's not discriminate with a boolean dammit
    public String email;
    public Course course1;
    public Course course2;
    public Course course3;
    
    /**
     * default constructor
     */
    public Student() {
        this.name = null;
        this.gender = null; //kek
        this.email = null;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }
    
    /**
     * constructor with student name, gender, and email
     * @param name student name
     * @param gender student gender
     * @param email student email
     */
    public Student(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }
    
    /**
     * full constructor for a student
     * @param name student name
     * @param gender student gender
     * @param email student email
     * @param course1 first course
     * @param course2 second course
     * @param course3 third course
     */
    public Student(String name, String gender, String email, 
            Course course1, Course course2, Course course3) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }
    
    /**
     * clone constructor
     * @param other student to clone data from
     */
    public Student(Student other) {
        this.name = other.name;
        this.gender = other.gender;
        this.email = other.email;
        this.course1 = other.course1;
        this.course2 = other.course2;
        this.course3 = other.course3;
    }
    
    /**
     * counts the amount of courses the student is passing
     * @return the number of passing classes
     */
    public int calcPassedCourseNum() {
        int passed = 0;
        if (course1.isPassed()) //this
            passed++;
        if (course2.isPassed()) //is
            passed++;
        if (course3.isPassed()) //ugly
            passed++;
        return passed;
    }
    
    /**
     * calculates student's accumulated credits
     * @return total number of course credits
     */
    public double calcTotalCredit() {
        double creds = 0;
        if (course1.isPassed()) //this
            creds += course1.getCredit();
        if (course2.isPassed()) //is
            creds += course2.getCredit();
        if (course3.isPassed()) //ugly
            creds += course3.getCredit();
        return creds;
    }
    
    /**
     * checks if an input string is a valid email
     * @param in string to check validity
     * @return true if valid, false if not
     */
    public boolean isEmailValid(String in) {
        int maxEmailLength = 320;
        int emailLen = in.length();
        if (emailLen > maxEmailLength)
            return false;
        if (!in.contains("@"))
            return false;
        if (!in.contains("."))
            return false;
        //this is after the contains checks to avoid errors
        int atIndex = in.indexOf("@");
        int dotIndex = in.lastIndexOf(".");
        if (dotIndex == emailLen - 1)
            return false;
        if (atIndex == 0)
            return false;
        /*
        haha no need for an iterator
        if dotIndex - atIndex is negative the last '.' is before the '@'
        if dotIndex - atIndex is 1 there's nothing between '@' and '.'
        if dotindex - atIndex is 0 then what the fuck is logic
        */
        return (dotIndex - atIndex) > 1;
    }
    
    public boolean equals(Student other) {
        return this.name.equals(other.name) &&
                this.gender.equals(other.gender) &&
                this.email.equals(other.email) &&
                this.course1.equals(other.course1) &&
                this.course2.equals(other.course2) &&
                this.course3.equals(other.course3);
    }
    
    @Override
    public String toString() {
        String out = "";
        out += String.format("%-15s: %s\n", "Name", name);
        out += String.format("%-15s: %s\n", "Gender", gender);
        out += String.format("%-15s: %s\n", "Email", email);
        out += String.format("\n%-17s%-28s%-10s%-10s\n", "Course", "Name",
                "Credit", "Score");
        out += "------------------------------------------------------------\n";
        out += String.format("%-15s: %-28s%-10.1f%-10.1f\n", 
                "Course 1", course1.getCourseName(), 
                course1.getCredit(), course1.calcFinalScore());
        out += String.format("%-15s: %-28s%-10.1f%-10.1f\n", 
                "Course 2", course2.getCourseName(), 
                course2.getCredit(), course2.calcFinalScore());
        out += String.format("%-15s: %-28s%-10.1f%-10.1f\n", 
                "Course 3", course3.getCourseName(), 
                course3.getCredit(), course3.calcFinalScore());
        out += "\n";
        out += String.format("%-15s: %d\n", "Passed Courses", 
                calcPassedCourseNum());
        out += String.format("%-15s: %.1f\n", "Total Credit", 
                calcTotalCredit());
        return out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isEmailValid(email))
            this.email = email;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void setCourse3(Course course3) {
        this.course3 = course3;
    }
}
