package GUI;

import MODELS.FacultyTag;
import MODELS.Professor;

import javax.swing.*;
import java.util.Arrays;

public class OptionCentricText extends JComboBox {
    public enum OptionsFrom {
        Faculties,
        MasterLevel,
    }

    public OptionCentricText(Object[] items) {
        super(items);
    }

    public OptionCentricText(OptionsFrom optionsFrom) {
        this(getOptionsName(optionsFrom));
    }

    public static Object[] getOptionsName(OptionsFrom optionsFrom) {
        switch (optionsFrom) {
            case Faculties:
                return (Arrays.stream(FacultyTag.values()).
                        map(FacultyTag::getMassage).toArray());
            case MasterLevel:
                return (Arrays.stream(Professor.MasterLevel.values()).
                        map(Professor.MasterLevel::getMassage).toArray());
        }
        return new Object[0];
    }
}