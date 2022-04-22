import GUI.Login;
import GUI.MainFrame;
import LOGIC.Command;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Command.setFrame(mainFrame);
    }
}
