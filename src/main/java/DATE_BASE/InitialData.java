package DATE_BASE;

import GUI.RealTime;
import MODELS.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.DocFlavor;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class InitialData {
    public static String SOURCE = "src/main/resources";
    public static String FACULTIES_SOURCE = SOURCE + "/faculties.json";
    public static String UNIVERSITY_SOURCE = SOURCE + "/university.json";
    public static Gson GSON;
    public InitialData() {
        /*new GsonBuilder().registerTypeAdapterFactory()
        GSON = new GsonBuilder().setPrettyPrinting().create();
        try {
            File file = new File(UNIVERSITY_SOURCE);
            Reader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            User[] users = GSON.fromJson(reader, User[].class);

            file = new File(FACULTIES_SOURCE);
            reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            Faculty[] faculties = GSON.fromJson(reader, Faculty[].class);

            Faculties.setInstance(new Faculties(new ArrayList<>(Arrays.asList(faculties))));

            for (Faculty faculty: faculties) {
                faculty.getFacultyTag().setFaculty(faculty);
            }
            for (User user: users) {
                addUserToFaculties(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        ArrayList<Faculty> faculties = new ArrayList<>();
        Faculty faculty = new Faculty("math", 0);
        faculties.add(faculty);
        University.setInstance(new University(faculties));

        ArrayList<Student> students = new ArrayList<>();
        faculty.addStudent(new Student(1234, "some typing"));
        faculty.addStudent(new Student(123, "try"));

        ArrayList<Professor> professors = new ArrayList<>();
        faculty.addProfessor(new CampusChairmen(1111, "foo"));
        faculty.addProfessor(new EducationalAssistant(111, "goo"));

        faculty.addCourses(new Course("riazi 1", 2004, new ArrayList<Course>(), new ArrayList<>()));
        ArrayList<Course> pre = new ArrayList<>();
        pre.add(faculty.getCourses().get(0));
        faculty.addCourses(new Course("riazi 2", 2005, pre, new ArrayList<>()));

        faculty.addClassrooms(new Classroom(1, 1, 12, LocalDateTime.now()));
    }

    public void addUserToFaculties(User user) {
        //the faculty student and professor field are retake
        if (user instanceof Student) {
        } else if (user instanceof CampusChairmen) {
            user.getFaculty().setCampusChairmen((CampusChairmen) user);
        } else if (user instanceof EducationalAssistant) {
            user.getFaculty().setEducationalAssistant((EducationalAssistant) user);
        } else if (user instanceof Professor){
            user.getFaculty().addProfessor((Professor) user);
        } else {
            System.out.println("break");
        }
    }

    public static void save() {
        try {
       /*     FileOutputStream fos;
            OutputStreamWriter isr = new OutputStreamWriter(fos,
                    StandardCharsets.UTF_8);

            isr.close();

            fos = new FileOutputStream(FACULTIES_SOURCE);
            isr = new OutputStreamWriter(fos,
                    StandardCharsets.UTF_8);
          //  Faculties.getInstance().deleteUsersOfFaculty();
           // GSON.toJson(Faculties.getInstance().getFaculties(), isr);

            isr.close();*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
