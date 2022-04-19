package MODELS;

public enum LoginResult implements ContainMessage {
    WRONG_USER_ID("user ID is not valid"),
    WRONG_PASSWORD("password is not correct"),
    PASS("");
    private String message;
    LoginResult(String message) {
        this.message = message;
    }
    @Override
    public String getMassage() {
        return message;
    }
}
