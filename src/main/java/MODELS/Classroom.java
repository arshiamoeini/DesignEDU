package MODELS;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Classroom {
    private int facultyID;
    private int courseID;
    private int teacherID;
    private int capacity;
    private ArrayList<LocalDateTime> time;

    public class classRating {
        private int studentID;
        private double score;

        public classRating(int studentID) {
            this.studentID = studentID;
        }
    }
    private ArrayList<classRating> students;
    private LocalDateTime examDate;

    public Classroom(int courseID, int teacherID, int capacity, LocalDateTime examDate) {
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.capacity = capacity;
        this.examDate = examDate;

        students = new ArrayList<>();
    }

    public void edit(int capacity) {
        this.capacity = Math.min(capacity, students.size());
    }
    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }
    public Faculty getFaculty() { return University.getInstance().getFaculty(facultyID); }

    public Course getCourse() { return getFaculty().getCourse(courseID); }

    public int getCapacity() { return capacity; }

    public int getRegistrationNumber() {
        return students.size();
    }
    public String getProfessorName() {
        return getFaculty().getProfessor(teacherID).getName();
    }
    public LocalDateTime getExamDate() {
        return examDate;
    }
}
