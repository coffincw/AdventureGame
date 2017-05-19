/**
 * Created by caleb on 5/11/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LanaWindow extends AdvWindow implements ActionListener {

    private AdvPanel locationPanel = new AdvPanel();
    private AdvPanel lanaSites = new AdvPanel();

    Player p;
    private JButton[] changeButtons = {new JButton("Capital"), new JButton("Back to Town"), new JButton("Exit Town Interior")};
    private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};

    public LanaWindow(Player p) {
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


        //setting viewable
        sidebar.setVisible(true);
        actions.setVisible(true);
        mainFrame.setVisible(true);
    }

    void cityComponents() {
        GridLayout cityGrid = new GridLayout(0, 4);
        cityGrid.setHgap(10);
        cityGrid.setVgap(2);
        cityView.addBorder(cityView, "Lana");
        cityView.setLayout(cityGrid);
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        addImage(cityView, "market.png");
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        addImage(cityView, "house.png");
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityGrid.layoutContainer(cityView);
        showInnerCityOptions();
    }

    void addImage(AdvPanel panel, String imagePath) {
        JLabel label = new JLabel();
        label.setIcon(panel.createImage(imagePath));
        label.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (imagePath.equals("market.png")) {

                } else if (imagePath.equals("house.png")) {

                }
                System.out.println("Yay you clicked me");
            }
        });
        panel.add(label);
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
            lanaSites.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            p.tempDistance = 0;
            InventoryWindow backpack = new InventoryWindow(p);
        } else if (e.getSource() == optionButtons[5]) { // "Explore"
            p.playerStats[2]++;
            p.city = "inner_lana";
            AdvPanel innerCity = new AdvPanel();
            for (int i = 0; i < optionButtons.length; i++) {
                actions.remove(optionButtons[i]);
            }
            mainFrame.remove(actions);
            actions.setVisible(false);
            cityComponents();
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
            GameplayWindow game = new GameplayWindow(p);

        } else if (e.getSource() == changeButtons[1] || e.getSource() == changeButtons[2]) { // "Back to Town"
            p.city = "lana";
            mainFrame.remove(sidebar);
            mainFrame.remove(actions);
            mainFrame.remove(cityView);
            mainFrame.remove(locationPanel);
            mainFrame.remove(lanaSites);
            lanaSites.setVisible(false);
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            locationPanel.setVisible(false);
            GameplayWindow game = new GameplayWindow(p);
        }
    }

    void showInnerCityOptions() {
        mainFrame.add(lanaSites, BorderLayout.AFTER_LAST_LINE);
        lanaSites.addBorder(lanaSites, "City Actions:");
        lanaSites.add(changeButtons[2]);
        changeButtons[2].setAlignmentX(Component.CENTER_ALIGNMENT);
        changeButtons[2].addActionListener(this);

    }

    void showLocationPanel() {

        mainFrame.add(locationPanel, BorderLayout.AFTER_LAST_LINE);
        locationPanel.addBorder(locationPanel, "Locations");

        for (int i = 0; i < changeButtons.length - 1; i++) {
            locationPanel.add(changeButtons[i]);
            changeButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            changeButtons[i].addActionListener(this);

        }

        locationPanel.setVisible(true);

    }


}
