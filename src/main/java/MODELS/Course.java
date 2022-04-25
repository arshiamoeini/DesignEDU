package MODELS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private int facultyID;

    public enum Program implements ContainMessage {
        UNDERGRADUATE("undergraduate"),
        MASTER_DEGREE("mater degree"),
        COMMON("common"),
        PHD("PHD");
        private String name;
        Program(String name) {
            this.name = name;
        }
        @Override
        public String getMassage() { return name; }
    }
    Program program;
    private String name;
    private int id;
    private int credit;
    private ArrayList<Course> prerequisite;
    private ArrayList<Course> coRequisite;

    public Course(String name, int id, ArrayList<Course> prerequisite, ArrayList<Course> coRequisite) {
        this.name = name;
        this.id = id;
        this.facultyID = facultyID;
        this.prerequisite = prerequisite;
        this.coRequisite = coRequisite;
    }

    protected void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }


    public void edit(String courseName, int courseCredit, ArrayList<Integer> prerequisite, ArrayList<Integer> coRequisite) {
        Faculty faculty = getFaculty();
        this.name = courseName;
        this.credit = courseCredit;
        this.prerequisite = new ArrayList<>(prerequisite.stream().map(x -> faculty.getCourse(x))
                .collect(Collectors.toList()));
        this.coRequisite = new ArrayList<>(coRequisite.stream().map(x -> faculty.getCourse(x))
                .collect(Collectors.toList()));
    }

    private Faculty getFaculty() {
        return University.getInstance().getFaculty(facultyID);
    }

    public Program getProgram() { return program; }
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
