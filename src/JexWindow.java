/**
 * Created by caleb on 5/11/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class JexWindow extends AdvWindow implements ActionListener {

    private AdvPanel locationPanel = new AdvPanel();

    Player p;
    private JButton[] changeButtons = {new JButton("Capital"), new JButton("Back to Town")};
    private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};

    public JexWindow(Player p) {
        this.p = p;
        cityView.currentWindow = 1;
        p.locationHistory.add(p.city);

        actions.addBorder(actions, "Actions");
        components();
        mainFrame.add(actions, BorderLayout.AFTER_LAST_LINE);
        cityView.setBackground(Color.GRAY);
        sidebar.setBackground(Color.WHITE);
        mainFrame.add(sidebar, BorderLayout.EAST);
        sidebar.addBorder(sidebar, "Options");


        mainFrame.add(cityView, BorderLayout.CENTER);


        cityView.addBorder(cityView, p.city);

        //setting viewable
        cityView.setVisible(true);
        sidebar.setVisible(true);
        actions.setVisible(true);
        mainFrame.setVisible(true);
    }

    void components() {
        GridLayout grid = new GridLayout(8, 8);
        sidebar.setLayout(grid);

        for (int b = 0; b <= optionButtons.length - 1; b++) {
            if (b <= 4) {

                addSidebarElement(b);

            } else {
                actions.add(optionButtons[b]);
                optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                optionButtons[b].addActionListener(this);
            }
        }
    }

    void addSidebarElement(int rep) {
        sidebar.add(optionButtons[rep]);
        optionButtons[rep].setAlignmentX(Component.CENTER_ALIGNMENT);
        optionButtons[rep].setPreferredSize(new Dimension(100, 100));
        optionButtons[rep].addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionButtons[0]) { // "Stats"
            JOptionPane.showMessageDialog(null, p.Stats(), "Stats", JOptionPane.INFORMATION_MESSAGE, statsIcon);
        } else if (e.getSource() == optionButtons[1]) { // "Gear"
            JOptionPane.showMessageDialog(null, p.gear.gearInfo(), "Gear", JOptionPane.INFORMATION_MESSAGE, gearIcon);
        } else if (e.getSource() == optionButtons[2]) { // "Map"
            JOptionPane.showMessageDialog(null, p.map(), "Map", JOptionPane.INFORMATION_MESSAGE, mapIcon);
        } else if (e.getSource() == optionButtons[3]) { // "History
            JOptionPane.showMessageDialog(null, p.history(), "Location History", JOptionPane.INFORMATION_MESSAGE, historyIcon);
        } else if (e.getSource() == optionButtons[4]) { // "Inventory"
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            p.tempDistance = 0;
            InventoryWindow backpack = new InventoryWindow(p);
        } else if (e.getSource() == optionButtons[5]) { // "Explore"
            p.playerStats[2]++;
        } else if (e.getSource() == optionButtons[6]) { // "Leave"
//            for (int i = 0 ; i < optionButtons.length ; i++) {
//                actions.remove(optionButtons[i]);
//            }
            mainFrame.remove(actions);

            actions.setVisible(false);

            showLocationPanel();
        } else if (e.getSource() == changeButtons[0]) { // "Capital"
            mainFrame.remove(locationPanel);
            mainFrame.remove(sidebar);
            mainFrame.remove(cityView);

            cityView.setVisible(false);
            sidebar.setVisible(false);
            locationPanel.setVisible(false);
//            for (int i = 0 ; i < changeButtons.length ; i++) {
//                locationPanel.remove(changeButtons[i]);
//            }

            p.city = "capital";
            CapitalWindow capital = new CapitalWindow(p);

        } else if (e.getSource() == changeButtons[1]) { // "Back to Town"
            actions.setVisible(false);
            GameplayWindow game = new GameplayWindow(p);
        }
    }

    void showLocationPanel() {

        mainFrame.add(locationPanel, BorderLayout.AFTER_LAST_LINE);
        locationPanel.addBorder(locationPanel, "Locations");

        for (int i = 0; i < changeButtons.length; i++) {
            locationPanel.add(changeButtons[i]);
            changeButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            changeButtons[i].addActionListener(this);

        }

        locationPanel.setVisible(true);

    }


}
