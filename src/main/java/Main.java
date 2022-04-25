import DATE_BASE.InitialData;
import GUI.Login;
import GUI.MainFrame;
import GUI.RealTime;
import LOGIC.Command;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        RealTime.dateAndTime(LocalDateTime.now());
        new InitialData();
        MainFrame mainFrame = new MainFrame();
        Command.setFrame(mainFrame);
    //    InitialData.save();
    }
}
