package LOGIC;

import GUI.*;
import MODELS.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}
