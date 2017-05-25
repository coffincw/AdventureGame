import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by caleb on 5/24/17.
 */
public class MarketWindow extends AdvWindow implements ActionListener {

    AdvPanel marketList = new AdvPanel();
    AdvPanel marketOptions = new AdvPanel();

    Player p;

    int[] cost = {};

    public MarketWindow(Player p) {
        this.p = p;
        marketList.currentWindow = 2;

        mainFrame.setTitle("Backpack");
        //setArray();

        actions.setBackground(Color.lightGray);
        marketList.setBackground(Color.WHITE);


        mainFrame.add(marketList, BorderLayout.CENTER);
        mainFrame.add(actions, BorderLayout.EAST);


        //adding borders
        marketList.addBorder(marketList, "Available");
        actions.addBorder(actions, "Options");

        components(p);
        mainFrame.validate();
        mainFrame.repaint();
        mainFrame.setVisible(true);
        //get month names

    }

    void components(Player p) {
        GridLayout grid2 = new GridLayout(30, 8);
        marketList.setLayout(grid2);
        JLabel consume = new JLabel("Consumables:");
        marketList.add(consume);

        for (int c = 0; c <= p.consumables.length - 1; c++) {
            SpinnerModel model =
                    new SpinnerNumberModel(0, //initial value
                            0, //min
                            p.items[2] / cost[c], //max
                            1);
            JSpinner spinner = new JSpinner(model);
            spinner.setAlignmentX(Component.LEFT_ALIGNMENT);
            marketList.add(spinner);
            marketList.add(new JLabel(p.CONSUMABLE_NAMES[c]));
            //consumeCB[c] = new JCheckBox(p.CONSUMABLE_NAMES[c] + " X " + p.consumables[c]);
            //consumeCB[c].setMnemonic(KeyEvent.VK_G);
            //consumeCB[c].setSelected(false);
            //list.add(consumeCB[c]);
            //consumeCB[c].setPreferredSize(new Dimension(200, 20));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
