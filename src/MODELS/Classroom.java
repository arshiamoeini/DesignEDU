package MODELS;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Classroom {
    private Course course;
    private Professor teacher;
    private int capacity;
    private ArrayList<Student> students;
    private LocalDateTime examDate;
    public Classroom(Course course, Professor teacher, int capacity) {
        examDate = LocalDateTime.now();
        this.course = course;
        this.teacher = teacher;
        this.capacity = capacity;

        students = new ArrayList<>();
    }

    public Course getCourse() { return course; }

    public int getCapacity() { return capacity; }

    public int getRegistrationNumber() {
        return students.size();
    }
    public String getProfessorName() {
        return teacher.name;
    }
    public LocalDateTime getExamDate() {
        return examDate;
    }
}
