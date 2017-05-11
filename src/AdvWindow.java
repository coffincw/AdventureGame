import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by caleb on 4/12/17.
 */
public class AdvWindow extends JFrame {
    static JFrame mainFrame = null;
    static AdvMap map = null;

    AdvPanel cityView = new AdvPanel();
    AdvPanel sidebar = new AdvPanel();
    AdvPanel actions = new AdvPanel();
    AdvPanel locationPanel = new AdvPanel();

    ImageIcon mapIcon = sidebar.createImageIcon("Thumbtack.png");
    ImageIcon gearIcon = sidebar.createImageIcon("gear.png");
    ImageIcon statsIcon = sidebar.createImageIcon("stats.png");
    ImageIcon historyIcon = sidebar.createImageIcon("history.png");

    static JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};
//


    static int currentRoomIndex;
    static int Cityndx;
    String city;






    public AdvWindow() {

        if (mainFrame == null) {
            mainFrame = new JFrame();
            map = new AdvMap();
        }

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 600);
        mainFrame.setResizable(false);


    }


}
