package MODELS;

import java.util.ArrayList;

public class Professor extends User {
    public enum MasterLevel implements ContainMessage {
        ASSISTANT_PROFESSOR("Assistant Professor"),
        ASSOCIATEـPROFESSOR("Associate Professor"),
        FULL_PROFESSOR("full Professor");
        public String message;
        MasterLevel(String message) {
            this.message = message;
        }
        @Override
        public String getMassage() { return message; }
    }

    private MasterLevel level;
    private ArrayList<Classroom> weeklyClasses;
    private long roomNumber;
    public Professor(long id, String password) {
        super(id, password);
    }
}
