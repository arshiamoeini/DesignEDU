package LOGIC;

import DATE_BASE.Faculties;
import DATE_BASE.Users;
import GUI.DemoList;
import GUI.EditableSubjectsList;
import GUI.MainFrame;
import GUI.SubjectsList;
import MODELS.*;

public class Command {
    private static Command instance;

    static {
        instance = new Command();
    }

    private User user = new EducationalAssistant(1234, "daf", Faculties.getInstance().getFaculty(0));
    private MainFrame mainFrame;

    public static Command getInstance() { return instance; }
    public static void setFrame(MainFrame mainFrame) {
        instance.mainFrame = mainFrame;
    }

    public LoginResult canLogin(LoginDate date) {
        if (!date.isValidUserID()) { return LoginResult.WRONG_USER_ID; }

        user = Users.getInstance().getUser(date.getUserID());
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
    public DemoList doSubjectFilter(int facultyIndex, int programIndex, boolean sortByExamDate) {
        DemoList demoList = (canUserEditSubjectsList(facultyIndex) ? new SubjectsList() :
                                                                    new EditableSubjectsList());
        Faculty faculty =  Faculties.getInstance().getFaculty(facultyIndex);
        for (Classroom classroom: faculty.getClassrooms()) {
            demoList.addSubjectRow(
                    classroom.getCourse().getId(),
                    classroom.getCourse().getCredit(),
                    classroom.getCourse().getName(),
                    classroom.getCourse().getPrerequisite(),
                    classroom.getCourse().getCoRequisite(),
                    classroom.getCapacity(),
                    classroom.getRegistrationNumber(),
                    classroom.getProfessorName(),
                    classroom.getExamDate());
        }
        return demoList;
            //if (classroom.getCourse().getProgram() == Course.Program.values()[programIndex]) {

            //}
    }
    private boolean canUserEditSubjectsList(int facultyIndex) {
        return  (user instanceof EducationalAssistant &&
            user.getFaculty().getFacultyTag() == FacultyTag.values()[facultyIndex]);
    }
    public void setSubjectEdit(String name) {
        System.out.println(name);
    }
    public String getNameOfUser() {
        return user.getName();
    }

    public boolean isTheUserAProfessor() {
        return user instanceof Professor;
    }
}
