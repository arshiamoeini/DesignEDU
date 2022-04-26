package MODELS;

import java.util.ArrayList;

public class GraduateStudent extends Student {
    private ArrayList<String> answeredRecommendations = new ArrayList<>();

    public GraduateStudent(long id, String password) {
        super(id, password);
    }

    public ArrayList<String> getRecommendationsText() {
        return answeredRecommendations;
    }

    public void addAnsweredRecommendation(String salam) {
        answeredRecommendations.add(salam);
    }
}
