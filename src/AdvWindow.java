import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by caleb on 4/12/17.
 */
public class AdvWindow extends JFrame {
    static JFrame mainFrame = null;
    static AdvMap map = null;





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
