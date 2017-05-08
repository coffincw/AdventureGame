import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by caleb on 4/15/17.
 */
public class InventoryWindow extends AdvWindow implements ActionListener, ItemListener {
    AdvPanel list = new AdvPanel();
    AdvPanel actions = new AdvPanel();

    Player p;

    private JButton[] invButtons = {new JButton("Exit Backpack"), new JButton("Use Item")};
    private JCheckBox[] consumeCB = new JCheckBox[6]; //length of consumables array
    private boolean[] effect = new boolean[6]; //length of consumables array


    public InventoryWindow(Player p) {
        this.p = p;

        list.currentWindow = 2;

        mainFrame.setTitle("Backpack");
        setArray();

        actions.setBackground(Color.lightGray);
        list.setBackground(Color.WHITE);


        mainFrame.add(list, BorderLayout.CENTER);
        mainFrame.add(actions, BorderLayout.EAST);


        //adding borders
        list.addBorder(list, "Contents");
        actions.addBorder(actions, "Options");

        components(p);
        mainFrame.validate();
        mainFrame.repaint();
        mainFrame.setVisible(true);

    }

    public void components(Player p) {
        GridLayout grid = new GridLayout(8, 8);
        actions.setLayout(grid);
//        BoxLayout layout = new BoxLayout(otherOptions, BoxLayout.Y_AXIS);
//        otherOptions.setLayout(layout);

        for (int b = 0; b <= invButtons.length - 1; b++) {
            actions.add(invButtons[b]);
            invButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
            invButtons[b].setPreferredSize(new Dimension(130, 100));
            invButtons[b].addActionListener(this);
        }

        JLabel nCoins = new JLabel("Coins: " + p.items[2]);
        nCoins.setFont(new Font("Serif", Font.PLAIN, 15));
        nCoins.setHorizontalAlignment(SwingConstants.CENTER);

        actions.add(nCoins);


        GridLayout grid2 = new GridLayout(30, 8);
        list.setLayout(grid2);
        JLabel consume = new JLabel("Consumables:");
        list.add(consume);

        for (int c = 0; c <= p.consumables.length - 1; c++) {
            if (p.consumables[c] != 0) {

                consumeCB[c] = new JCheckBox(p.CONSUMABLE_NAMES[c] + " X " + p.consumables[c]);
                consumeCB[c].setMnemonic(KeyEvent.VK_G);
                consumeCB[c].setSelected(false);
                list.add(consumeCB[c]);
                consumeCB[c].setPreferredSize(new Dimension(200, 20));
                consumeCB[c].setAlignmentX(Component.LEFT_ALIGNMENT);
                consumeCB[c].addItemListener(this);
            }
        }

//        list.setLayout(new BoxLayout(list, BoxLayout.LINE_AXIS));
        //list.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == invButtons[0]) {
//            mainFrame.setLayout(new CardLayout());
//            mainFrame.remove(actions);
//            mainFrame.remove(list);
//            mainFrame.add(gp);
            list.setVisible(false);
            actions.setVisible(false);
            GameplayWindow gp = new GameplayWindow(p);
        } else if (e.getSource() == invButtons[1]) {
            for (int check = 0; check <= consumeCB.length - 1; check++) {
                if (effect[check]) {
                    p.playerStats[1] += p.healAmount[check];
                    p.consumables[check]--;
                    list.setVisible(false);
                    actions.setVisible(false);
                    InventoryWindow inv = new InventoryWindow(p);
                }
            }
        }
    }

    void invUpdate(int c) {


    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        for (int items = 0; items <= p.consumables.length - 1; items++) {
            if (source == consumeCB[items] && e.getStateChange() == ItemEvent.SELECTED) {
                effect[items] = true;
            }
            if (source == consumeCB[items] && e.getStateChange() == ItemEvent.DESELECTED) {
                effect[items] = false;
            }
        }

    }

    void setArray() {
        for (int e = 0; e <= effect.length - 1; e++) {
            effect[e] = false;
        }
    }
}
