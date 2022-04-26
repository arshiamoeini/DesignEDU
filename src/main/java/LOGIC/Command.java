package LOGIC;

import GUI.*;
import MODELS.*;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private static Command instance;

    static {
        instance = new Command();
    }

    private User user = University.getInstance().getUser(111);
    private MainFrame mainFrame;

    public static Command getInstance() { return instance; }
    public static void setFrame(MainFrame mainFrame) {
        instance.mainFrame = mainFrame;
    }

    public void addRecommendation(int selectedProfessorIndex) {
        Professor professor = getInstance().getFaculty().getProfessor(selectedProfessorIndex);
        professor.addRecommendation(user.getId());
        //University.getInstance().getFaculty()
    }

    public LoginResult canLogin(LoginDate date) {
        if (!date.isValidUserID()) { return LoginResult.WRONG_USER_ID; }

        user = University.getInstance().getUser(date.getUserID());
        if (user == null) { return LoginResult.WRONG_USER_ID; }

        if (user.getHashOfPassword() == date.getHashOfPassword()) {
            return LoginResult.PASS;
        } else {
            return LoginResult.WRONG_PASSWORD;
        }
    }

    public void showUserPage() {
        //some second wait
        mainFrame.uploadPage();
    }

    protected boolean canUserEditSubjectsList(Faculty faculty) {
        return  (user instanceof EducationalAssistant && user.isIn(faculty));
    }
    public String getNameOfUser() {
        return user.getName();
    }

    public boolean isTheUserAProfessor() {
        return user instanceof Professor;
    }

    protected User getUser() { return user; }
    protected EducationalAssistant getEducationalAssistant() {
        return (EducationalAssistant) user;
    }

    public ArrayList<EducationalServicesDesigner.WeeklyClassSchedule> getSchedule() {
        return Filter.getInstance().getSchedule(user.getWeeklyClasses());
    }

    public ArrayList<EducationalServicesDesigner.WeeklyClassSchedule> getExamSchedule() {
        return Filter.getInstance().getExamSchedule(user.getWeeklyClasses());
    }

    public String getNameOfUserFaculty() {
        return user.getFaculty().getMassage();
    }

    public void addWithdrawalRequest() {
        getFaculty().addEducationalRequest(Faculty.RequestType.WITHDRAWAL,
                "not in good mod",
                user.getId());
    }

    public boolean isTheUSerABachelorStudent() {
        return user instanceof BachelorStudent;
    }
    public boolean isTheUserAGraduateStudent() {
        return user instanceof GraduateStudent;
    }

    public Faculty getFaculty() {
        return user.getFaculty();
    }

    public ArrayList<String> getRecommendationsText() {
        if (user instanceof GraduateStudent) {
            return ((GraduateStudent) user).getRecommendationsText();
        } else if (user instanceof BachelorStudent) {
            return ((BachelorStudent) user).getRecommendationsText();
        }
        return null;
    }

    public ArrayList<BachelorStudent.MajorRequest> getMajorRequests() {
        return ((BachelorStudent) user).getMajorRequests();
    }

    public void addMajor(int selectedIndex) {
        ((BachelorStudent) user).addMajorRequest(selectedIndex);
        getFaculty().addEducationalRequest(Faculty.RequestType.MAJOR,
                (String) University.getInstance().getFacultiesName()[selectedIndex],
                user.getId());
    }

    public String getUserID() {
        return String.valueOf(user.getId());
    }

    public void sendRecommendation(Student student, String text) {
        ((Professor) user).removeRecommendation(student.getId());
        if (student instanceof BachelorStudent) {
            ((BachelorStudent) student).addAnsweredRecommendation(text);
        } else if (student instanceof GraduateStudent) {
            ((GraduateStudent) student).addAnsweredRecommendation(text);
        } else {
            System.out.println("wrong way send recommendation");
        }
    }

    public List<Student> getRecommendedStudent() {
        if (user instanceof Professor) {
            return ((Professor) user).getRecommendedStudents();
        } else {
            System.out.println("werwr");
            return null;
        }
    }

    public boolean isTheUserAPHDStudent() {
        return user instanceof PhDStudent;
    }

    public boolean isTheUserAEducationalAssistant() {
        return user instanceof EducationalAssistant;
    }

    public void acceptingRequest(Faculty.EducationalRequest request) {
        getEducationalAssistant().acceptRequest(request);
    }

    public void rejectingRequest(Faculty.EducationalRequest request) {
        getEducationalAssistant().rejectRequest(request);
    }
}
