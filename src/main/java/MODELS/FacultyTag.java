package MODELS;

public enum FacultyTag implements ContainMessage {
    MATH("math");

    private String name;

    FacultyTag(String name) {
        this.name = name;
    }
    @Override
    public String getMassage() {
        return name;
    }
}
