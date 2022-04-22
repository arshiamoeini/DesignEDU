package GUI;

import MODELS.Faculty;
import MODELS.FacultyTag;

import javax.swing.*;
import java.util.Arrays;

public class OptionCentricText extends JComboBox {
    public OptionCentricText(Object[] items) {
        super(items);
    }

    public OptionCentricText() {
        this(Arrays.stream(FacultyTag.values()).map(FacultyTag::getMassage).toArray());
    }
}
