import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.FlowLayout;


/**
 * Created by caleb on 4/12/17.
 */
public class AdvWindow extends JFrame {
    static JFrame mainFrame;

    public AdvWindow() {

        mainFrame = new JFrame("Carthage");


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 600);
        mainFrame.setResizable(false);


    }


}
