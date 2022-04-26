package MODELS;

import java.util.ArrayList;

public class EducationalAssistant extends Professor {
    public EducationalAssistant(long id, String password) {
        super(id, password);
    }

    public void editClassroom(Classroom classroom,
                              int courseID,
                              int courseCredit,
                              String courseName,
                              ArrayList<Integer> prerequisite,
                              ArrayList<Integer> coRequisite,
                              int capacity,
                              int registrationNumber,
                              String professorName) {
        //TODO edit courseID and professorName
        //TODO DELETE registrationNumber
        classroom.edit(capacity);
        classroom.getCourse().edit(courseName, courseCredit, prerequisite, coRequisite);
        //TODO have object of class in hear from (show demo) maybe filter obj in command to help command
        //getFaculty().getClassroom()
    }

    public void acceptRequest(Faculty.EducationalRequest request) {
        getFaculty().removeRequest(request);
        //TODO Handel
        if (request.getRequestType() == Faculty.RequestType.MAJOR) {
            Student student = request.getStudent();
            if (student instanceof BachelorStudent) {
                ((BachelorStudent) student).acceptMajor(request.getMassage());
            } else {
                System.out.println("sdfaseeed");
            }
        }
    }

    public void rejectRequest(Faculty.EducationalRequest request) {
        getFaculty().removeRequest(request);
        if (request.getRequestType() == Faculty.RequestType.MAJOR) {
            Student student = request.getStudent();
            if (student instanceof BachelorStudent) {
                ((BachelorStudent) student).rejectMajor(request.getMassage());
            } else {
                System.out.println("sdfasd");
            }
        }
    }
}
