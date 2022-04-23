package MODELS;

import DATE_BASE.Faculties;
import DATE_BASE.Users;

import java.util.ArrayList;

public class Faculty {
    private FacultyTag facultyTag;
    private Professor campusChairmen;
    private EducationalAssistant educationalAssistant;

    private ArrayList<Professor> professors;
    private ArrayList<Student> students;

    private ArrayList<Course> courses;
    private ArrayList<Classroom> classrooms;

    public Faculty(FacultyTag facultyTag) {
        this.facultyTag = facultyTag;

        campusChairmen = new Professor(100, "1234", this);
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

    public FacultyTag getFacultyTag() { return facultyTag; }
    public Professor getCampusChairmen() { return campusChairmen; }
}
