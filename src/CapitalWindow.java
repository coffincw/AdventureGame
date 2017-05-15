/**
 * Created by caleb on 5/11/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapitalWindow extends AdvWindow implements ActionListener {

    private AdvPanel capitalLocations = new AdvPanel();

    Player p;
    private JButton[] locationButtons = {new JButton("Jex"), new JButton("Lana"), new JButton("Back to Town")};
    private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};


    public CapitalWindow(Player p) {
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


        mainFrame.add(background.addBackground("capital_background.png"));
        mainFrame.add(cityView, BorderLayout.CENTER);


        cityComponents();

        cityView.addBorder(cityView, p.city);


        //setting viewable
        cityView.setVisible(true);
        sidebar.setVisible(true);
        actions.setVisible(true);
        mainFrame.setVisible(true);
    }

    void cityComponents() {

        GridLayout cityGrid = new GridLayout(0, 3);
        cityGrid.setHgap(10);
        cityGrid.setVgap(2);
        cityView.setLayout(cityGrid);
        cityView.addImage(cityView, "house.png");
        cityView.addImage(cityView, "bank.png");
        cityView.addImage(cityView, "house.png");
        cityView.add(new JLabel(""));
        cityView.addImage(cityView, "house.png");
        cityGrid.layoutContainer(cityView);
    }

    void components() {
        GridLayout grid = new GridLayout(8, 8);
        sidebar.setLayout(grid);
//        BoxLayout layout = new BoxLayout(actions, BoxLayout.Y_AXIS);
//        actions.setLayout(layout);

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
            for (int i = 0; i < optionButtons.length; i++) {
                actions.remove(optionButtons[i]);
            }
            mainFrame.remove(sidebar);
            mainFrame.remove(actions);
            mainFrame.remove(cityView);
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            showLocationPanel();
        } else if (e.getSource() == locationButtons[0]) { // "Jex"
            mainFrame.remove(sidebar);
            mainFrame.remove(actions);
            mainFrame.remove(cityView);
            mainFrame.remove(capitalLocations);
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            capitalLocations.setVisible(false);

//            for (int i = 0 ; i < locationButtons.length ; i++) {
//                capitalLocations.remove(locationButtons[i]);
//            }
            p.city = "jex";
            JexWindow jex = new JexWindow(p);

        } else if (e.getSource() == locationButtons[1]) { // "Lana"
            mainFrame.remove(sidebar);
            mainFrame.remove(actions);
            mainFrame.remove(cityView);
            mainFrame.remove(capitalLocations);
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            capitalLocations.setVisible(false);
            p.city = "lana";
            LanaWindow lana = new LanaWindow(p);


        } else if (e.getSource() == locationButtons[2]) { // "Back to Town"
            mainFrame.remove(sidebar);
            mainFrame.remove(actions);
            mainFrame.remove(cityView);
            mainFrame.remove(capitalLocations);
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            capitalLocations.setVisible(false);
            GameplayWindow game = new GameplayWindow(p);
        }
    }

    void showLocationPanel() {
        mainFrame.add(capitalLocations, BorderLayout.AFTER_LAST_LINE);
        capitalLocations.addBorder(capitalLocations, "Locations");
        for (int i = 0; i < locationButtons.length; i++) {
            capitalLocations.add(locationButtons[i]);
            locationButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            locationButtons[i].addActionListener(this);

        }
        capitalLocations.setVisible(true);

    }


}
