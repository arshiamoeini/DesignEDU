package MODELS;

public class LoginDate {
    String userID;
    String password;

    public LoginDate(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public boolean isValidUserID() {
        try {
            Long.parseUnsignedLong(userID);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isValidPassword() {
        //TODO
        return true;
    }

    public long getUserID() { return Long.valueOf(userID); }
    public int getHashOfPassword() { return password.hashCode(); }
}
