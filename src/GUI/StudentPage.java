package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class StudentPage {
    private JPanel panel1;
    private JTabbedPane main;
    private JTabbedPane register;
    private JList list1;

    public StudentPage() {
        main.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int index = ((JTabbedPane) changeEvent.getSource()).getSelectedIndex();
                CardLayout cards = (CardLayout) panel1.getLayout();
                //cards.show(panel1, "Card"+index);
                cards.first(panel1);
                for (int i = 0;i < index;++i) {
                    cards.next(panel1);
                }
                panel1.repaint();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void createUIComponents() {
     //   table1.setColumnModel();
      //  table1.set
    }
}
