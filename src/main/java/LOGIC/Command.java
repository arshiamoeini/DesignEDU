package LOGIC;

import DATE_BASE.Users;
import GUI.MainFrame;
import MODELS.LoginDate;
import MODELS.LoginResult;
import MODELS.Professor;
import MODELS.User;

public class Command {
    private static Command instance;

    static {
        instance = new Command();
    }

    private User user;
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
    public String getNameOfUser() {
        return user.getName();
    }

    public boolean isTheUserAProfessor() {
        return user instanceof Professor;
    }
}
