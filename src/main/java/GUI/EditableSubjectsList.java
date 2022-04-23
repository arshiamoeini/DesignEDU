package GUI;

import LOGIC.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EditableSubjectsList extends EditableDemoList {
    public EditableSubjectsList() {
        super();
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
    }

    @Override
    public void addSubjectRow(int id, int credit, String name, ArrayList<Integer> prerequisite, ArrayList<Integer> coRequisite, int capacity, int registrationNumber, String professorName, LocalDateTime examDate) {
        gbcFiller.gridy = (rowsCounter++);
        columnCounter = 0;
        setComponentAtRow(new CellPane(new editButton(rowsCounter)), columnCounter++);
        super.addSubjectRow(id, credit, name, prerequisite, coRequisite, capacity, registrationNumber, professorName, examDate);
        setComponentAtRow(new CellPane(new deleteButton(rowsCounter)), columnCounter++);
    }

    @Override
    protected void addActionHandler() {
        //TODO
    }

    @Override
    protected void editActionHandler(int rowNumber) {
        JButton button = (JButton) getCellPane(rowNumber, 0).getLabel();
        for (int i = 1;i <= 8;++i) {
            getCellPane(rowNumber, i).setEditable();
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command.getInstance().setSubjectEdit(getCellPane(rowNumber, 1).getText());
            }
        });
    }

    @Override
    protected void deleteActionHandler(int rowNumber) {
        //TODO
    }
}
