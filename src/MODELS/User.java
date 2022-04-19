package MODELS;

import java.awt.*;

public class User {
    long id;
    int hashOfPassword;

    String name;
    String email;
    Image image;

    public User(long id, String password) {
        this.id = id;
        setPassword(password);
    }

    public void setPassword(String password) { hashOfPassword = password.hashCode(); }

    public long getId() { return id; }
    public int getHashOfPassword() { return hashOfPassword; }
}
