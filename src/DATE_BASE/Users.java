package DATE_BASE;

import MODELS.Professor;
import MODELS.User;

import java.util.ArrayList;

public class Users {
    private static Users instance;

    static {
        instance = new Users();
    }

    ArrayList<User> users;

    public Users() {
        users = new ArrayList<>();

        users.add(new User(400108044, "1234"));
        users.add(new Professor(100, "1234"));
    }

    public static Users getInstance() {
        return instance;
    }

    public User getUser(long userID) {
        for (User user: users) {
            if (user.getId() == userID) {
                return user;
            }
        }
        return null;
    }
}
