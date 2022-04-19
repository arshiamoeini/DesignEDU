package LOGIC;

import DATE_BASE.Users;
import MODELS.LoginDate;
import MODELS.LoginResult;
import MODELS.User;

public class Command {
    private static Command instance;

    static {
        instance = new Command();
    }

    public static Command getInstance() { return instance; }
    public LoginResult canLogin(LoginDate date) {
        if (!date.isValidUserID()) { return LoginResult.WRONG_USER_ID; }

        User user = Users.getInstance().getUser(date.getUserID());
        if (user == null) { return LoginResult.WRONG_USER_ID; }

        if (user.getHashOfPassword() == date.getHashOfPassword()) {
            return LoginResult.PASS;
        } else {
            return LoginResult.WRONG_PASSWORD;
        }
    }
}
