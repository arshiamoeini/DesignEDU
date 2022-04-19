package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CellPane extends JPanel {
    private Component label;

    public CellPane(Component label) {
        this.label = label;
        setBackground(new Color(73, 144, 183, 144));
        setBorder(new LineBorder(Color.BLACK));
        add(label);
    }
}
