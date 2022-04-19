package GUI;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class List extends JScrollPane {
    String[] columnsTitle = {
            "course id",
            "credit",
            "course name",
            "<html>prerequisite and<br>co-requisite</html>",
            "capacity",
            "registration number",
            "professor name",
            "exam date",
    };

    public void addRow(long id,
                       int credit,
                       String name,
                       ArrayList<Integer> prerequisite,
                       ArrayList<Integer> coRequisite,
                       int capacity,
                       int registrationNumber,
                       String professorName,
                       LocalDateTime examDate) {
        gbcFiller.gridy = rowsCounter;
        ++rowsCounter;

        gbcFiller.gridx = 0;

        addCopyableText(String.valueOf(id), 0);
        addCopyableText(String.valueOf(credit), 1);
        addCopyableText(name, 2);
        addCopyableText(
                "prerequisite:\n" +
                        joinArrayListWithEndLine(prerequisite) +
                        "co-requisite:\n" +
                        joinArrayListWithEndLine(coRequisite), 3);
        addCopyableText(String.valueOf(capacity), 4);
        addCopyableText(String.valueOf(registrationNumber), 5);
        addCopyableText(professorName, 6);
        addCopyableText(RealTime.dateAndTime(examDate), 7);
        // pane.getComponent()
    }

    private void addCopyableText(String text, int columnNumber) {
        gbcFiller.gridx = columnNumber;
        JTextArea textLabel = new JTextArea(text);
        textLabel.setEditable(false);
        pane.add(new CellPane(textLabel), gbcFiller);
    }

    private String joinArrayListWithEndLine(ArrayList<Integer> array) {
        return array.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

    int[] padeSizeInRow = {};

    private JPanel pane = new JPanel();
    int rowsCounter = 1;
    private GridBagConstraints gbcFiller = new GridBagConstraints();

    public List() {
        //setting
        setSize(new Dimension(MainFrame.MAIN_WIDTH - 100, MainFrame.MAIN_HEIGHT - 100));
        setBackground(Color.RED);
        setOpaque(true);

        pane.setLayout(new GridBagLayout());
        designTopics();
        setViewportView(pane);

        repaint();
    }

    private void designTopics() {
        //gbcFiller.insets = new Insets(3, 3, 3, 3);
        gbcFiller.gridy = 0;
        gbcFiller.fill = GridBagConstraints.BOTH;
        CellPane cell;
        for (int i = 0; i < columnsTitle.length; ++i) {
            cell = new CellPane(new JLabel(columnsTitle[i]));
            gbcFiller.gridx = i;
            pane.add(cell, gbcFiller);
        }
    }
}