import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by caleb on 4/15/17.
 */
public class GameplayWindow extends AdvWindow {


    Player p;

    //    static private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};
    static private JButton[] changeButtons = {new JButton("Capital"), new JButton("Jex"), new JButton("Lana"), new JButton("Back to Town")};
    //static private JButton[] changeButtons = {new JButton("")};

    public GameplayWindow(Player p) {

        System.out.println(p.city);


        switch (p.city) {
            case "capital":
            case "inner_capital": {
                CapitalWindow capital = new CapitalWindow(p);
                break;
            }
            case "jex":
            case "inner_jex": {
                JexWindow jex = new JexWindow(p);
                break;
            }
            case "lana":
            case "inner_lana": {
                LanaWindow lana = new LanaWindow(p);
                break;
            }
        }
    }
}

