package DATE_BASE;

import MODELS.*;

import java.util.ArrayList;

public class Faculties {
    private static Faculties instance;

    static  {
        instance = new Faculties();
    }

    private ArrayList<Faculty> faculties;

    public Faculties() {
        faculties = new ArrayList<>();
        Faculty faculty = new Faculty(FacultyTag.MATH);
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

    public Faculty getFaculty(int index) {
        return faculties.get(index);
    }
    protected ArrayList<Faculty> getFaculties() {
        return faculties;
    }
}
