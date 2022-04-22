package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class StudentPage extends MainPage {
    private JPanel panel1;
    private JTabbedPane main;
    private JTabbedPane registrationMatters;
    private JPanel professorList;
    private JComboBox comboBox1;

    public StudentPage() {
        main.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int index = ((JTabbedPane) changeEvent.getSource()).getSelectedIndex();
                CardLayout cards = (CardLayout) panel1.getLayout();
                cards.show(panel1, "Card" + (index + 1));
            /*    cards.first(panel1);
                for (int i = 0;i < index;++i) {
                    cards.next(panel1);
                }*/
                panel1.repaint();
            }
        });
      //  panel1.add("Card2", new List());
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
     //   table1.setColumnModel();
      //  table1.set
    }
}
