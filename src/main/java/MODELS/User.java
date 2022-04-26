package MODELS;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private long id;
    private int hashOfPassword;
    private int facultyID;

    String name = "somebody";
    long nationalCode;
    long phoneNumber;
    String email;
    Image image;

    private ArrayList<Integer> weeklyClassesID;

    public User(long id, String password) {
        this.id = id;
        setPassword(password);

        weeklyClassesID = new ArrayList<>();
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }
    public void setPassword(String password) { hashOfPassword = password.hashCode(); }

    public void addClass(int Id) {
        weeklyClassesID.add(Id);
    }
    public long getId() { return id; }
    public int getHashOfPassword() { return hashOfPassword; }

    public String getName() { return name; }
    public Faculty getFaculty() { return University.getInstance().getFaculty(facultyID); }

    public boolean isIn(Faculty faculty) {
        return facultyID == faculty.getID();
    }

    public List<Classroom> getWeeklyClasses() {
        Faculty faculty = getFaculty();
        return weeklyClassesID.stream().map(x -> faculty.getClassroom(x)).collect(Collectors.toList());
    }

    public void setName(String name) {
        this.name = name;
    }
}
