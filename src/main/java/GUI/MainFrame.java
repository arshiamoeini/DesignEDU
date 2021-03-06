package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int MAIN_WIDTH = 600;
    public static final int MAIN_HEIGHT = 500;

    public MainFrame() throws HeadlessException {
        //setting
        setSize(MAIN_WIDTH, MAIN_HEIGHT);
        setResizable(false);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();

        Rectangle mainScreen = gd[0].getDefaultConfiguration().getBounds();
        int upLeftCornerX = mainScreen.x + mainScreen.width / 2 - MAIN_WIDTH / 2;
        int upLeftCornerY = mainScreen.y + mainScreen.height / 2 - MAIN_HEIGHT / 2;
        setLocation(upLeftCornerX, upLeftCornerY);

        //JPanel p =  new JPanel();
     //   p.add(new List());
       /* List list = new List();
        Classroom classroom = Faculties.getInstance().getFaculty().getClassrooms().get(0);
        System.out.println(classroom == null);
*/
        setLayout(null);
        //getContentPane().add(list, BorderLayout.CENTER);
        setContentPane(Login.getInstance().getPanel());//new EducationalServicesDesigner().getPanel()); //ListDesigner.getInstance().getPanel());); //Login.getInstance().getLoginPane());  //new MainPage().getPane()););
        repaint();
        //setJMenuBar((new StudentMenus()).mb);//(new MainPage()).panel1);//RealTime.getPanel());//Login.getInstance().getLoginPane());

        revalidate();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void uploadPage() {
        setContentPane(new MainPage().getPane());
        repaint();
    }
}
