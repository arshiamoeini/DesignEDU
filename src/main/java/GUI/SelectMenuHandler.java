package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SelectMenuHandler implements ChangeListener {
    /*
        panel should have layout = CardLayout and main JTabbedPane

        this listener add on the main JTabbedPane that is in component of panel
        so with click on that menus bar we Scroll between cards of panel
     */
    private JPanel panel;

    public SelectMenuHandler(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        int index = ((JTabbedPane) changeEvent.getSource()).getSelectedIndex();
        CardLayout cards = (CardLayout) panel.getLayout();
        cards.show(panel, "Card" + (index + 1));
            /*    cards.first(panel1);
                for (int i = 0;i < index;++i) {
                    cards.next(panel1);
                }*/
        panel.repaint();
    }
}
