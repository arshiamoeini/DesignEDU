package GUI;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SubjectsList extends DemoList {
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

        addCopyableTextInRow(String.valueOf(id), 0);
        addCopyableTextInRow(String.valueOf(credit), 1);
        addCopyableTextInRow(name, 2);
        addCopyableTextInRow(
                "prerequisite:\n" +
                        joinArrayListWithEndLine(prerequisite) +
                        "co-requisite:\n" +
                        joinArrayListWithEndLine(coRequisite), 3);
        addCopyableTextInRow(String.valueOf(capacity), 4);
        addCopyableTextInRow(String.valueOf(registrationNumber), 5);
        addCopyableTextInRow(professorName, 6);
        addCopyableTextInRow(RealTime.dateAndTime(examDate), 7);
        // pane.getComponent()
    }
//    int[] padeSizeInRow = {};

    public SubjectsList() {
        super();
        //setting
    //    setSize(new Dimension(MainFrame.MAIN_WIDTH - 100, MainFrame.MAIN_HEIGHT - 100));
    //    setBackground(Color.RED);
    //    setOpaque(true);

        //set topics
        columnsTitle = new String[]{
                "course id",
                "credit",
                "course name",
                "<html>prerequisite and<br>co-requisite</html>",
                "capacity",
                "registration number",
                "professor name",
                "exam date",
        };
        designTopics();

        repaint();
    }

}