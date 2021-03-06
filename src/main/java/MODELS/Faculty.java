package MODELS;

import java.util.ArrayList;

public class Faculty implements ContainMessage {
    private String name;
    private int facultyID;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;


    private ArrayList<Course> courses;
    private ArrayList<Classroom> classrooms;

    private int campusChairmenID;
    private int educationalAssistantID;

    public void addEducationalRequest(RequestType type, String text, long studentSourceID) {
        educationalRequests.add(new EducationalRequest(type, text, studentSourceID));
    }
    public void removeRequest(EducationalRequest request) {
        educationalRequests.remove(request);
    }

    public ArrayList<EducationalRequest> getEducationalRequests() {
        return educationalRequests;
    }

    public enum RequestType implements ContainMessage {
        WITHDRAWAL("Withdrawal"),
        MAJOR("Major");
        private String message;

        RequestType(String message) {
            this.message = message;
        }

        @Override
        public String getMassage() {
            return message;
        }
    }
    public class EducationalRequest implements ContainMessage {
        private RequestType requestType;
        private String message;
        private long studentSourceID;

        public EducationalRequest(RequestType requestType, String message, long studentSourceID) {
            this.requestType = requestType;
            this.message = message;
            this.studentSourceID = studentSourceID;
        }
        public RequestType getRequestType() {
            return requestType;
        }
        public Student getStudent() {
            return (Student) University.getInstance().getUser(studentSourceID);
        }

        @Override
        public String getMassage() {
            return message;
        }
    }
    private ArrayList<EducationalRequest> educationalRequests;
    public Faculty(String name, int facultyID) {
        this.name = name;
        this.facultyID = facultyID;
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.campusChairmenID = 0;
        this.educationalAssistantID = 1;
        this.educationalRequests = new ArrayList<>();
    }

    /*
    public Faculty() {
        this.facultyTag = facultyTag;
        this.campusChairmen = campusChairmen;

        courses = new ArrayList<>();
        classrooms = new ArrayList<>();
        professors = new ArrayList<>();
        students = new ArrayList<>();
    }
    */

    @Override
    public String getMassage() { return name; }

    public void addCourses(Course course) {
        courses.add(course);
        course.setFacultyID(facultyID);
    }
    public void addClassrooms(Classroom classroom) {
        classrooms.add(classroom);
        classroom.setFacultyID(facultyID);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setFacultyID(facultyID);
    }
    public void addProfessor(Professor professor) {
        professors.add(professor);
        professor.setFacultyID(facultyID);
    }

    public void setCampusChairmen(CampusChairmen campusChairmen) {
    }
    public void setEducationalAssistant(EducationalAssistant educationalAssistant) {
    }
    public void deleteUsers() {
        professors.clear();
        students.clear();
    }
    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Classroom> getClassrooms() { return classrooms; }

    public User getUser(long userID) {
        for (Student student: students) {
            if (student.getId() == userID) {
                return student;
            }
        }
        for (Professor professor: professors){
            if (professor.getId() == userID) {
                return professor;
            }
        }
        return null;
    }

    public Professor getProfessor(int id) {
        return professors.get(id);
    }
    public Course getCourse(int id) { return courses.get(id); }
    public int getID() { return facultyID; }

    public int getEducationalAssistantID() {
        if (educationalAssistantID == -1) {
            return campusChairmenID;
        } else {
            return educationalAssistantID;
        }
    }

    public Classroom getClassroom(int index) {
        return classrooms.get(index);
    }

    public Object[] getProfessorsName() {
        return professors.stream().map(Professor::getName).toArray();
    }
}
