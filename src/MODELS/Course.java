package MODELS;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Course {
    private Faculty faculty;
    private String name;
    private int id;
    private int credit;
    private ArrayList<Course> prerequisite;
    private ArrayList<Course> coRequisite;

    public Course(String name, int id, ArrayList<Course> prerequisite, ArrayList<Course> coRequisite) {
        this.name = name;
        this.id = id;
        this.prerequisite = prerequisite;
        this.coRequisite = coRequisite;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }
    public int getCredit() {
        return credit;
    }

    public String getName() { return name; }

    public ArrayList<Integer> getPrerequisite() {
        return getCoursesID(prerequisite);
    }
    public ArrayList<Integer> getCoRequisite() {
        return getCoursesID(coRequisite);
    }
    private ArrayList<Integer> getCoursesID(ArrayList<Course> courses) {
        return new ArrayList<>(
                courses.stream().map(Course::getId).collect(Collectors.toList()));
    }
}