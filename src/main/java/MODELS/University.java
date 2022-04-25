package MODELS;

import java.util.ArrayList;

public class University {
    private static University instance;

    private ArrayList<Faculty> faculties;

    public static void setInstance(University university) {
        instance = university;
    }
    public static University getInstance() {
        return instance;
    }

    public University(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }


    public User getUser(long userID) {
        User user;
        for (Faculty faculty: faculties) {
            user = faculty.getUser(userID);
            if (user != null) {
                return user;
            }
        }
        return null;
    }
    public Faculty getFaculty(int id) {
        return faculties.get(id);
    }

    public Object[] getFacultiesName() {
        return faculties.stream().map(Faculty::getMassage).toArray();
    }
}
