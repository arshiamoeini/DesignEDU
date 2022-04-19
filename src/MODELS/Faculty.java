package MODELS;

import java.util.ArrayList;

public class Faculty {
    private Professor campusChairmen;
    private EducationalAssistant educationalAssistant;

    private ArrayList<Professor> professors;
    private ArrayList<Student> students;

    private ArrayList<Course> courses;
    private ArrayList<Classroom> classrooms;

    public Faculty(Professor campusChairmen) {
        this.campusChairmen = campusChairmen;

        courses = new ArrayList<>();
        classrooms = new ArrayList<>();
        professors = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourses(Course course) { courses.add(course); }
    public void addClassrooms(Classroom classroom) {
        classrooms.add(classroom);
    }

    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Classroom> getClassrooms() { return classrooms; }
}
