package GUI;

import javax.swing.*;

public class ProfessorPage implements PanelDesigner {
    private JPanel panel;
    private JTabbedPane main;
    private JPanel registrationMatters;

    public ProfessorPage() {
        main.addChangeListener(new SelectMenuHandler(panel));

        panel.add("Card2", new ListDesigner().getPanel());
        panel.add("Card3", new EducationalServicesDesigner().getPanel());
    }

    @Override
    public JPanel getPanel() { return panel; }
}
