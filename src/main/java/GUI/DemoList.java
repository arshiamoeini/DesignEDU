package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DemoList extends JScrollPane {
    protected String[] columnsTitle;

  //  int[] padeSizeInRow = {};

    protected JPanel pane = new JPanel();
    protected int rowsCounter = 1;
    protected GridBagConstraints gbcFiller = new GridBagConstraints();

    public DemoList() {
        //setting
        setSize(new Dimension(MainFrame.MAIN_WIDTH - 100, MainFrame.MAIN_HEIGHT - 100));
        setBackground(Color.RED);
        setOpaque(true);

        pane.setLayout(new GridBagLayout());
        setViewportView(pane);
    }

    protected void designTopics() {
        //gbcFiller.insets = new Insets(3, 3, 3, 3);
        gbcFiller.gridy = 0;
        gbcFiller.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < columnsTitle.length; ++i) {
            gbcFiller.gridx = i;
            pane.add(new CellPane(columnsTitle[i]), gbcFiller);
        }
    }

    protected void addCopyableTextInRow(String text, int columnNumber) {
        gbcFiller.gridx = columnNumber;
        pane.add(new CellPane(text, false), gbcFiller);
    }
    protected static String joinArrayListWithEndLine(ArrayList<Integer> array) {
        return array.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }
}
