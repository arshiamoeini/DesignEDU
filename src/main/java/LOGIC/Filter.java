package LOGIC;

import GUI.*;
import MODELS.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Filter {
    private static Filter instance;

    static {
        instance = new Filter();
    }

    private ArrayList<Classroom> subjects;

    private class SubjectFilterDate {
        public Faculty faculty;
        public Course.Program program;
        public DemoList demoList;
        public SubjectFilterDate(Faculty faculty, Course.Program program) {
            this.faculty = faculty;
            this.program = program;
        }
        public void addClassroomToList(Classroom classroom) {
            demoList.addSubjectRow(
                    classroom.getCourse().getId(),
                    classroom.getCourse().getCredit(),
                    classroom.getCourse().getName(),
                    classroom.getCourse().getPrerequisite(),
                    classroom.getCourse().getCoRequisite(),
                    classroom.getCapacity(),
                    classroom.getRegistrationNumber(),
                    classroom.getProfessorName(),
                    classroom.getExamDate());
            subjects.add(classroom);
           // demoList.revalidate();
            ((EditableSubjectsList) demoList).editActionHandler(subjects.size() + 1);
        }
    }
    SubjectFilterDate subjectFilterDate;

    public static Filter getInstance() {
        return instance;
    }

    public Filter() {
        subjects = new ArrayList<>();
    }

    public DemoList doSubjectFilter(int facultyIndex, int programIndex, boolean sortByExamDate) {
        Faculty faculty = University.getInstance().getFaculty(facultyIndex);

        subjectFilterDate = new SubjectFilterDate(faculty, Course.Program.values()[programIndex]);
        getFilteredSubject(sortByExamDate);

        DemoList demoList;
        if (Command.getInstance().canUserEditSubjectsList(faculty)) {
            demoList = new EditableSubjectsList();
        } else {
            demoList = new SubjectsList();
        }

        subjectFilterDate.demoList = demoList;
        for (Classroom classroom: subjects) {
            subjectFilterDate.addClassroomToList(classroom);
        }
        return demoList;
    }
    private void getFilteredSubject(boolean sortByExamDate) {
        subjects.clear();
        for (Classroom classroom: subjectFilterDate.faculty.getClassrooms()) {
            subjects.add(classroom);

            //if (classroom.getCourse().getProgram() == Course.Program.values()[programIndex]) {

            //}
        }
    }

    public void setSubjectEdit(int row,
                               int id,
                               int credit,
                               String name,
                               ArrayList<Integer> prerequisite,
                               ArrayList<Integer> coRequisite,
                               int capacity,
                               int registrationNumber,
                               String professorName) {
        Command.getInstance().getEducationalAssistant().
                editClassroom(subjects.get(row - 1), id, credit, name, prerequisite, coRequisite, capacity, registrationNumber, professorName);
        ListDesigner.getInstance().showSubjectsList();
    }

    public void addNewSubject() {
        int counter = subjectFilterDate.faculty.getCourses().size();
        int pre = subjectFilterDate.faculty.getID();
        subjectFilterDate.faculty.
                addCourses(new Course("", pre * 100 + counter, new ArrayList<>(), new ArrayList<>()));
        Classroom classroom = new Classroom(pre * 100 + counter,
                subjectFilterDate.faculty.getEducationalAssistantID(),
                0,
                LocalDateTime.now());
        subjectFilterDate.faculty.addClassrooms(classroom);
    }
}
