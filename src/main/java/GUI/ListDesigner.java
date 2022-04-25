package GUI;

import LOGIC.Command;
import LOGIC.Filter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDesigner implements PanelDesigner {
    private static ListDesigner instance;

    static {
        instance = new ListDesigner();
    }
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
        facultySelector = new OptionCentricText(OptionCentricText.OptionsFrom.Faculties);
        programSelector = new OptionCentricText(OptionCentricText.OptionsFrom.Program);

        facultyFilter.add(facultySelector,
                BorderLayout.CENTER);
        programItems.add(programSelector);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSubjectsList();
            }
        });
    }

    public void showSubjectsList() {
        DemoList demoList = LOGIC.Filter.getInstance().doSubjectFilter(
                facultySelector.getSelectedIndex(),
                programSelector.getSelectedIndex(),
                sortRadio.isSelected());
        subjectsList.add(demoList, BorderLayout.CENTER);
        subjectsList.repaint();
        subjectsList.revalidate();
    }

    public static ListDesigner getInstance() {
        return instance;
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
