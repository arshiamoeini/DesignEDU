package GUI.REQUEST_MENU;

import GUI.PanelDesigner;
import GUI.RealTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Random;

public class PHDRequestsMenu implements PanelDesigner {
    private JTabbedPane PHDStudent;
    private JPanel recommendationField;
    private JPanel withdrawalField;
    private JButton requestButton;
    private JLabel showRequestResult;
    private JPanel panel;

    public PHDRequestsMenu() {
        BachelorStudentRequestsMenu bachelorStudentRequestsMenu = new BachelorStudentRequestsMenu();

        recommendationField.add(bachelorStudentRequestsMenu.getRecommendationMenu(), BorderLayout.CENTER);
        withdrawalField.add(bachelorStudentRequestsMenu.getWithdrawalMenu());
        requestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRequestResult.setText(String.format("On %s you can defend your dissertation.",
                        RealTime.dateAndTime(LocalDateTime.now().plusDays(12))));
                showRequestResult.revalidate();
            }
        });
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
