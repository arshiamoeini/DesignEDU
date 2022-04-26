package GUI;

import javax.swing.*;

public class StudentPage extends MainPage implements PanelDesigner {
    private JPanel panel;
    private JTabbedPane main;
    private JTabbedPane registrationMatters;
    private JPanel professorList;
    private JComboBox comboBox1;

    public StudentPage() {
        main.addChangeListener(new SelectMenuHandler(panel));

        panel.add("Card2", new ListDesigner().getPanel());
        panel.add("Card3", new EducationalServicesDesigner().getPanel());
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
     //   table1.setColumnModel();
      //  table1.set
    }
}
