package GUI;

import LOGIC.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDesigner implements PanelDesigner {
    private JTabbedPane tabbedPane1;
    private JPanel panel;
    private JButton showButton;
    private JComboBox selectedFaculty;
    private JPanel facultyFilter;
    private JRadioButton sortRadio;
    private JPanel FilterByOther;
    private JPanel filterMenu;
    private JPanel programItems;
    private JPanel Filter;
    private JPanel subjectsList;
    private static OptionCentricText facultySelector = new OptionCentricText(OptionCentricText.OptionsFrom.Faculties);
    private static OptionCentricText programSelector = new OptionCentricText(OptionCentricText.OptionsFrom.Program);
    public ListDesigner() {
        facultyFilter.add(facultySelector,
                BorderLayout.CENTER);
        programItems.add(programSelector);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DemoList demoList = Command.getInstance().doSubjectFilter(
                        facultySelector.getSelectedIndex(),
                        programSelector.getSelectedIndex(),
                        sortRadio.isSelected());
                subjectsList.add(demoList, BorderLayout.CENTER);
                subjectsList.repaint();
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
