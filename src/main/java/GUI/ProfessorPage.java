package GUI;

import javax.swing.*;

public class ProfessorPage implements PanelDesigner {
    private JPanel panel;
    private JTabbedPane main;
    private JPanel registrationMatters;

    public ProfessorPage() {
        main.addChangeListener(new SelectMenuHandler(panel));
    }

    @Override
    public JPanel getPanel() { return panel; }
}
