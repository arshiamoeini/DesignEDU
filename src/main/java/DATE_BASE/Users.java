package DATE_BASE;

import MODELS.Faculty;
import MODELS.Professor;
import MODELS.Student;
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

   //     for (Faculty faculty: Faculties.getInstance().getFaculties()) {
    //        users.add(faculty.getCampusChairmen());
    //    }
        users.add(new User(400108044, "1234", Faculties.getInstance().getFaculty(0)));
        users.add(new Student(1234, "some typing", Faculties.getInstance().getFaculty(0)));
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
    public void addUser(User user) {
        users.add(user);
    }
}
