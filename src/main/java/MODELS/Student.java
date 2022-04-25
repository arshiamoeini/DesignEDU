package MODELS;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Student extends User {
    public enum EducationalStatus implements ContainMessage {
        ALLOWED_TO_REGISTER("Allowed to register"),
        PUT_OF("put of");

        private String message;

        EducationalStatus(String message) {
            this.message = message;
        }

        @Override
        public String getMassage() {
            return message;
        }
    }

    public EducationalStatus educationalStatus;
    private Professor Supervisor;
    private boolean registrationLicense;
    private LocalDateTime registrationTime;

    private ArrayList<Classroom> weeklyClasses;
    public Student(long id, String password) {
        super(id, password);
    }

    public void setSupervisor(Professor supervisor) {
        Supervisor = supervisor;
    }
    public Professor getSupervisor() {
        return Supervisor;
    }
}
