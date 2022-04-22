package DATE_BASE;

import MODELS.Classroom;
import MODELS.Course;
import MODELS.Faculty;
import MODELS.Professor;

import java.util.ArrayList;

public class Faculties {
    private static Faculties instance;

    static  {
        instance = new Faculties();
    }

    ArrayList<Faculty> faculties;

    public Faculties() {
        faculties = new ArrayList<>();
        Faculty faculty = new Faculty((Professor) Users.getInstance().getUser(100));
        faculty.addCourses(new Course("riazi 1", 2004, new ArrayList<Course>(), new ArrayList<>()));
        ArrayList<Course> pre = new ArrayList<>();
        pre.add(faculty.getCourses().get(0));
        faculty.addCourses(new Course("riazi 2", 2005, pre, new ArrayList<>()));
        faculty.addClassrooms(new Classroom(faculty.getCourses().get(1),
                (Professor) Users.getInstance().getUser(100), 50));
        faculties.add(faculty);
    }

    public static Faculties getInstance() {
        return instance;
    }

    public Faculty getFaculty() {
        return faculties.get(0);
    }
}
