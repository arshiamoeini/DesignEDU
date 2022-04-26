package GUI;

import MODELS.Course;
import MODELS.Faculty;
import MODELS.Professor;
import MODELS.University;

import javax.swing.*;
import java.util.Arrays;

public class OptionCentricText extends JComboBox {
    public enum OptionsFrom {
        Faculties,
        MasterLevel,
        Program,
        Professor
    }

    public OptionCentricText(Object[] items) {
        super(items);
    }

    public OptionCentricText(OptionsFrom optionsFrom) {
        this(getOptionsName(optionsFrom));
    }
    public OptionCentricText(Faculty faculty) {
        this(faculty.getProfessorsName());
    }

    public static Object[] getOptionsName(OptionsFrom optionsFrom) {
        switch (optionsFrom) {
            case Faculties:
                return University.getInstance().getFacultiesName();
            case MasterLevel:
                return (Arrays.stream(Professor.MasterLevel.values()).
                        map(Professor.MasterLevel::getMassage).toArray());
            case Program:
                return (Arrays.stream(Course.Program.values()).
                        map(Course.Program::getMassage).toArray());
        }
        return new Object[0];
    }
}