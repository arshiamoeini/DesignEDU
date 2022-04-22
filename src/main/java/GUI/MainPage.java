package GUI;

import LOGIC.Command;

import javax.swing.*;
import java.awt.*;

public class MainPage {
    private JPanel pane;
    private JPanel info;
    private JPanel logo;
    private RealTime realTime;
    private JLabel some;
    private JPanel out;

    public MainPage() {
        if (Command.getInstance().isTheUserAProfessor()){
            pane.add(new ProfessorPage().getPanel(), BorderLayout.CENTER);
        } else {
            pane.add(new StudentPage().getPanel(), BorderLayout.CENTER);
        }
    }

    public JPanel getPane() {
        return pane;
    }
}
