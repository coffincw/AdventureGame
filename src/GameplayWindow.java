import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by caleb on 4/15/17.
 */
public class GameplayWindow extends AdvWindow implements ActionListener {


    ArrayList<AdvPanel> locationPanels = new ArrayList<>();
    ArrayList<AdvPanel> actionPanel = new ArrayList<>();



    String city;


    Player p;

    //    static private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};
    static private JButton[] changeButtons = {new JButton("Capital"), new JButton("Jex"), new JButton("Lana"), new JButton("Back to Town")};
    //static private JButton[] changeButtons = {new JButton("")};

    public GameplayWindow(Player p) {

        this.p = p;
        cityView.currentWindow = 1;
        System.out.println(p.nDistance);
        city = AdvMap.CITY_NAMES[currentRoomIndex];
        p.locationHistory.add(city);

        actions.addBorder(actions, "Actions");
        components();
        mainFrame.add(actions, BorderLayout.AFTER_LAST_LINE);
        cityView.setBackground(Color.GRAY);
        if (p.tempDistance < 1) {
            sidebar.setBackground(Color.WHITE);
            mainFrame.add(sidebar, BorderLayout.EAST);
            sidebar.addBorder(sidebar, "Options");
        }

        mainFrame.add(cityView, BorderLayout.CENTER);


        cityView.addBorder(cityView, city);

        //setting viewable
        cityView.setVisible(true);
        sidebar.setVisible(true);
        actions.setVisible(true);
        mainFrame.setVisible(true);


    }


    void components() {
        GridLayout grid = new GridLayout(8, 8);
        sidebar.setLayout(grid);
//        BoxLayout layout = new BoxLayout(actions, BoxLayout.Y_AXIS);
//        actions.setLayout(layout);

        for (int b = 0; b <= optionButtons.length - 1; b++) {
            if (b <= 4) {
                if (p.tempDistance < 1) {
                    sidebar.add(optionButtons[b]);
                    optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                    optionButtons[b].setPreferredSize(new Dimension(100, 100));
                    optionButtons[b].addActionListener(this);
                }

            } else {
                actions.add(optionButtons[b]);
                optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                optionButtons[b].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionButtons[0]) { // "Stats"
            JOptionPane.showMessageDialog(null, p.Stats(), "Stats", JOptionPane.INFORMATION_MESSAGE, statsIcon);
        } else if (e.getSource() == optionButtons[1]) { // "Gear"
            JOptionPane.showMessageDialog(null, p.gear.gearInfo(), "Gear", JOptionPane.INFORMATION_MESSAGE, gearIcon);
        } else if (e.getSource() == optionButtons[2]) { // "Map"
            JOptionPane.showMessageDialog(null, map(), "Map", JOptionPane.INFORMATION_MESSAGE, mapIcon);
        } else if (e.getSource() == optionButtons[3]) { // "History
            JOptionPane.showMessageDialog(null, history(), "Location History", JOptionPane.INFORMATION_MESSAGE, historyIcon);
        } else if (e.getSource() == optionButtons[4]) { // "Inventory"
            cityView.setVisible(false);
            sidebar.setVisible(false);
            actions.setVisible(false);
            p.tempDistance = 0;
            InventoryWindow backpack = new InventoryWindow(p);
        } else if (e.getSource() == optionButtons[5]) { // "Explore"
            p.playerStats[2]++;
        } else if (e.getSource() == optionButtons[6]) { // "Leave"
            actions.setVisible(false);
            showLocationPanel(map.getRoom(currentRoomIndex).travel());
        } else if (e.getSource() == changeButtons[0]) { // "Capital"
            mainFrame.remove(locationPanel);
            locationPanel.remove(changeButtons[0]);
            city = "capital";
            changeLocation();


        } else if (e.getSource() == changeButtons[1]) { // "Jex"
            mainFrame.remove(locationPanel);
            locationPanel.remove(changeButtons[1]);
            city = "jex";
            changeLocation();

        } else if (e.getSource() == changeButtons[2]) { // "Lana"
            mainFrame.remove(locationPanel);
            locationPanel.remove(changeButtons[2]);
            city = "lana";
            changeLocation();


        } else if (e.getSource() == changeButtons[3]) { // "Back to Town"
            actions.setVisible(false);
            GameplayWindow game = new GameplayWindow(p);
        }
    }

    void showLocationPanel(ArrayList<Integer> direction) {
        mainFrame.add(locationPanel, BorderLayout.AFTER_LAST_LINE);
        locationPanel.addBorder(locationPanel, "Locations");

        for (int i = 0; i < direction.size(); i++) {
            locationPanel.add(changeButtons[direction.get(i) - 1]);
            changeButtons[direction.get(i) - 1].setAlignmentX(Component.CENTER_ALIGNMENT);
            changeButtons[direction.get(i) - 1].addActionListener(this);

        }
        locationPanel.add(changeButtons[3]);
        changeButtons[3].setAlignmentX(Component.CENTER_ALIGNMENT);
        changeButtons[3].addActionListener(this);
        locationPanel.setVisible(true);

    }



    String map() { // displays a print out version of map
        return "                                                     " +
                "\n    (Jex) ---- (Capital) ---- (Lana)           " +
                "\n                                                     ";
    }

    String history() {
        String his = "";
        for (String i : p.locationHistory) {
            his += " " + i + "\n";
        }
        return his;
    }

    public void changeLocation() {
        p.nDistance += 1;
        p.tempDistance += 1;
        Cityndx = AdvMap.directionNumber(city);
        AdvLocation nowRoom = map.getRoom(currentRoomIndex);
        AdvLocation targetRoom = nowRoom.roomInDirection(AdvMap.directionNumber(city));
        if (targetRoom != null) {
            currentRoomIndex = targetRoom.getIndex();
            targetRoom.handleElement();
        }

        GameplayWindow game = new GameplayWindow(p);

    }
}
