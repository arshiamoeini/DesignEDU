package GUI.REQUEST_MENU;

import GUI.*;
import LOGIC.Command;
import MODELS.BachelorStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class BachelorStudentRequestsMenu implements PanelDesigner {
    private JTabbedPane bachelorStudent;
    private JPanel panel;
    private JButton addRecommendation;
    private JButton certificateButton;
    private JTextArea certificateText;
    private JButton addMajor;
    private JPanel applyMajored;
    private JPanel majorList;
    private JButton outOfUniversity;
    private JPanel recommendationField;
    private JPanel recommendationList;
    private JPanel majorMenu;
    private JPanel certificateMenu;
    private JPanel recommendationMenu;
    private JPanel withdrawalMenu;

    public BachelorStudentRequestsMenu() {
    }

    private void recommendationInit() {
        recommendationField.add(new OptionCentricText(Command.getInstance().getFaculty()),
                BorderLayout.CENTER);
        addRecommendation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command.getInstance().addRecommendation(
                        ((OptionCentricText) recommendationField.getComponent(1)).getSelectedIndex());
            }
        });
        recommendationList.add(new DemoList() {
            {
                columnsTitle = new String[]{"click to show recommendation", "text area"};
                designTopics();
                for (String recommendationText: Command.getInstance().getRecommendationsText()) {
                    addRow(recommendationText);
                }
            }
            private void addRow(String recommendationText) {
                gbcFiller.gridy = rowsCounter++;

                JButton button = new JButton();
                gbcFiller.gridx = columnCounter++;
                pane.add(button, gbcFiller);
                CellPane textArea = addCopyableTextInRowForEdit("");

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ((JTextArea) textArea.getLabel()).setText(recommendationText);
                    }
                });
            }
        });
    }
    private void certificateInit() {
        certificateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                certificateText.setText(String.format("It is certified that Mr. / Mrs. %s with student number %s \nis studying in %s field at Sharif University. \n Certificate validity date: %s",
                        Command.getInstance().getNameOfUser(),
                        Command.getInstance().getUserID(),
                        Command.getInstance().getNameOfUserFaculty(),
                        RealTime.dateAndTime(LocalDateTime.now().plusYears(4))));
            }
        });
    }
    private void withdrawalInit() {
        outOfUniversity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command.getInstance().addWithdrawalRequest();
            }
        });
    }
    private void majorInit() {
        applyMajored.add(new OptionCentricText(OptionCentricText.OptionsFrom.Faculties));
        addMajor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command.getInstance().addMajor(((OptionCentricText) applyMajored.getComponent(1)).
                        getSelectedIndex());
                updateMajorList();
            }
        });
        updateMajorList();
    }
    private void updateMajorList() {
        majorList.removeAll();
        majorList.add(new DemoList() {
            {
                columnsTitle = new String[] {"faculty name", "status"};
                designTopics();
                for (BachelorStudent.MajorRequest majorRequest: Command.getInstance().getMajorRequests()) {
                    addRow(majorRequest.getFacultyName(), majorRequest.getStatus());
                }
            }
            public void addRow(String facultyName, String status) {
                gbcFiller.gridy = rowsCounter++;
                columnCounter = 0;
                addCopyableTextInRow(facultyName);
                addCopyableTextInRow(status);
            }
        });
        majorMenu.revalidate();
    }
    @Override
    public JPanel getPanel() {
        recommendationInit();
        certificateInit();
        withdrawalInit();
        majorInit();

        panel.revalidate();
        return panel;
    }

    public JPanel getRecommendationMenu() {
        recommendationInit();
        return recommendationMenu;
    }
    public JPanel getCertificateMenu() {
        certificateInit();
        return certificateMenu;
    }

    public JPanel getWithdrawalMenu() {
        withdrawalInit();
        return withdrawalMenu;
    }
}
