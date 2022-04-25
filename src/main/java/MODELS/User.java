package MODELS;

import java.awt.*;

public class User {
    private long id;
    private int hashOfPassword;
    private int facultyID;

    String name;
    long nationalCode;
    long phoneNumber;
    String email;
    Image image;

    public User(long id, String password) {
        this.id = id;
        setPassword(password);
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }
    public void setPassword(String password) { hashOfPassword = password.hashCode(); }

    public long getId() { return id; }
    public int getHashOfPassword() { return hashOfPassword; }

    public String getName() { return name; }
    public Faculty getFaculty() { return University.getInstance().getFaculty(facultyID); }

    public boolean isIn(Faculty faculty) {
        return facultyID == faculty.getID();
    }
}
