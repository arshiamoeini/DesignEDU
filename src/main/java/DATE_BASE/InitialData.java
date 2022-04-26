package DATE_BASE;

import MODELS.*;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class InitialData {
    public static String SOURCE = "src/main/resources";
    public static String FACULTIES_SOURCE = SOURCE + "/faculties.json";
    public static String UNIVERSITY_SOURCE = SOURCE + "/university.json";
    public static Gson GSON;
    public InitialData() {
        /*
        try {


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

    /*    {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(User.class , new UserAdapter());
            builder.setPrettyPrinting();
            GSON = builder.create();
        }
        File file = new File(UNIVERSITY_SOURCE);
        try {
            FileOutputStream fos = new FileOutputStream(FACULTIES_SOURCE);
            OutputStreamWriter isr = new OutputStreamWriter(fos,
                    StandardCharsets.UTF_8);

            GSON.toJson(new GraduateStudent(100, "123"), isr);

            isr.close();

*/
            //User[] users = GSON.fromJson(reader, User[].class);
/*            Reader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);

            User user = GSON.fromJson(reader, User.class);
            System.out.println(user == null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        ArrayList<Faculty> faculties = new ArrayList<>();

        Faculty faculty = new Faculty("math", 0);
        faculties.add(faculty);
        University.setInstance(new University(faculties));

        ArrayList<Student> students = new ArrayList<>();
        faculty.addStudent(new Student(1234, "some typing"));
        faculty.addStudent(new Student(123, "try"));
        faculty.addStudent(new BachelorStudent(12, "12341"));
        faculty.addStudent(new GraduateStudent(1, "1234"));
        faculty.addStudent(new PhDStudent(12345, "1234"));
        ((BachelorStudent) faculty.getUser(12)).addAnsweredRecommendation("salam");
        ((BachelorStudent) faculty.getUser(12)).addAnsweredRecommendation("khobi");

        ArrayList<Professor> professors = new ArrayList<>();
        faculty.addEducationalRequest(Faculty.RequestType.MAJOR, "math", 12);
        faculty.addProfessor(new CampusChairmen(1111, "foo") {
            {
                setName("boss");
            }
        });
        faculty.addProfessor(new EducationalAssistant(111, "goo"){
            {
                setName("ali");
 //               addRecommendation(12);
            }
        });

        faculty.addCourses(new Course("riazi 1", 2004, new ArrayList<Course>(), new ArrayList<>()));
        ArrayList<Course> pre = new ArrayList<>();
        pre.add(faculty.getCourses().get(0));
        faculty.addCourses(new Course("riazi 2", 2005, pre, new ArrayList<>()));

        ArrayList<LocalDateTime> times = new ArrayList<>();
        times.add(LocalDateTime.of(1401, 1, 1, 12, 30));
        faculty.addClassrooms(new Classroom(1, 1, 12, LocalDateTime.of(1400, 12, 1, 12, 30), times));
        faculty.addClassrooms(new Classroom(0, 1, 12, LocalDateTime.of(1400, 12, 2, 12, 30), times));
        University.getInstance().getUser(111).addClass(1);
        University.getInstance().getUser(111).addClass(0);
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
