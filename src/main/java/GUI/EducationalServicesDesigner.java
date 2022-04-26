package GUI;

import GUI.REQUEST_MENU.GraduateRequestsMenu;
import GUI.REQUEST_MENU.BachelorStudentRequestsMenu;
import GUI.REQUEST_MENU.PHDRequestsMenu;
import GUI.REQUEST_MENU.ProfessorRequestMenu;
import LOGIC.Command;

import javax.swing.*;

public class EducationalServicesDesigner implements PanelDesigner {
//    private static EducationalServicesDesigner instance;

    private JPanel educationalServices;
    private JPanel weeklySchedule;
    private JPanel examSchedule;
    private JTabbedPane main;

    public static class WeeklyClassSchedule {
        String name;
        String teacher;
        String time;

        public WeeklyClassSchedule(String name, String teacher, String time) {
            this.name = name;
            this.teacher = teacher;
            this.time = time;
        }

        @Override
        public String toString() {
            return String.format("%s (%s) %s", name, teacher, time);
        }
    }
  //  static {
   //     instance = new EducationalServicesDesigner();
   // }

    public EducationalServicesDesigner() {
        main.addChangeListener(new SelectMenuHandler(educationalServices));
        educationalServices.add("Card2",
                Command.getInstance().isTheUSerABachelorStudent() ?
                new BachelorStudentRequestsMenu().getPanel() :
                        Command.getInstance().isTheUserAGraduateStudent() ?
                        new GraduateRequestsMenu().getPanel() :
                                Command.getInstance().isTheUserAPHDStudent() ?
                                        new PHDRequestsMenu().getPanel() :
                                            Command.getInstance().isTheUserAProfessor() ?
                                            new ProfessorRequestMenu().getPanel() :
                                                null);

        //TODO SORT weekly class
        for (WeeklyClassSchedule clazz:  Command.getInstance().getSchedule()) {
            weeklySchedule.add(new JLabel(clazz.toString()));

        }
        for (WeeklyClassSchedule clazz: Command.getInstance().getExamSchedule()) {
            examSchedule.add(new JLabel(clazz.toString()));
        }
    }

    @Override
    public JPanel getPanel() {
        return educationalServices;
    }
}
