package GUI;

import LOGIC.Command;
import LOGIC.Filter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

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
        setComponentAtRow(new CellPane(new editButton(gbcFiller.gridy)), columnCounter++);
        super.addSubjectRow(id, credit, name, prerequisite, coRequisite, capacity, registrationNumber, professorName, examDate);
        setComponentAtRow(new CellPane(new deleteButton(gbcFiller.gridy)), columnCounter++);
    }

    @Override
    public void addActionHandler() {
        //TODO disjoind add classroom and course
        Filter.getInstance().addNewSubject();
    }

    @Override
    public void editActionHandler(int rowNumber) {
        JButton button = getEditButton(rowNumber);
        for (int i = 1;i <= 8;++i) {
            getCellPane(rowNumber, i).setEditable();
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Integer>[] requisite = readRequisite(getCellPane(rowNumber, 4).getText());
                    Filter.getInstance().setSubjectEdit(
                            rowNumber,
                            Integer.valueOf(getCellPane(rowNumber, 1).getText()),
                            Integer.valueOf(getCellPane(rowNumber, 2).getText()),
                            getCellPane(rowNumber, 3).getText(),
                            requisite[0],
                            requisite[1],
                            Integer.valueOf(getCellPane(rowNumber, 5).getText()),
                            Integer.valueOf(getCellPane(rowNumber, 6).getText()),
                            getCellPane(rowNumber, 7).getText());
                   //         readLocalDateTime(getCellPane(rowNumber, 1).getText()));
                } catch (Exception error) {
                    System.out.println(error);
                }

            }
        });
    }

    private LocalDateTime readLocalDateTime(String text) {
        return LocalDateTime.now();
    }

    private ArrayList<Integer>[] readRequisite(String text) {
        ArrayList<Integer> prerequisite = new ArrayList<>();
        ArrayList<Integer> coRequisite = new ArrayList<>();

        Scanner reader = new Scanner(text);
        if (reader.next().equals("prerequisite:")) {
            while (reader.hasNextInt()) {
                prerequisite.add(reader.nextInt());
            }
            if (reader.next().equals("co-requisite:")) {
                while (reader.hasNextInt()) {
                    coRequisite.add(reader.nextInt());
                }
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
        return new ArrayList[]{prerequisite, coRequisite};
    }

    @Override
    protected void deleteActionHandler(int rowNumber) {
        //TODO
        if (getEditButton(rowNumber).getActionListeners()[0] instanceof editButton) {
            //not edit mod
        }
    }
}
