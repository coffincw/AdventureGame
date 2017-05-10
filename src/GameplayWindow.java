import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by caleb on 4/15/17.
 */
public class GameplayWindow extends AdvWindow implements ActionListener {

    AdvPanel game = new AdvPanel();
    AdvPanel options = new AdvPanel();
    AdvPanel otherOptions = new AdvPanel();
    AdvPanel locationPanel = new AdvPanel();

    static int currentRoomIndex;
    static int Cityndx;

    String city;


    Player p;
    private ImageIcon mapIcon = options.createImageIcon("Thumbtack.png");
    private ImageIcon gearIcon = options.createImageIcon("gear.png");
    private ImageIcon statsIcon = options.createImageIcon("stats.png");

    static private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("History"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};
    static private JButton[] changeButtons = {new JButton("Capital"), new JButton("Jex"), new JButton("Lana"), new JButton("Back to Town")};

    public GameplayWindow(Player p) {

        this.p = p;
        game.currentWindow = 1;
        System.out.println(p.nDistance);
        city = AdvMap.CITY_NAMES[currentRoomIndex];
        p.locationHistory.add(city);

        otherOptions.addBorder(otherOptions, "Actions");
        components();
        mainFrame.add(otherOptions, BorderLayout.AFTER_LAST_LINE);
        game.setBackground(Color.GRAY);
        if (p.tempDistance < 1) {
            options.setBackground(Color.WHITE);
            mainFrame.add(options, BorderLayout.EAST);
            options.addBorder(options, "Options");
        }

        mainFrame.add(game, BorderLayout.CENTER);


        game.addBorder(game, city);

        //setting viewable
        game.setVisible(true);
        options.setVisible(true);
        otherOptions.setVisible(true);
        mainFrame.setVisible(true);


    }


    void components() {
        GridLayout grid = new GridLayout(8, 8);
        options.setLayout(grid);
//        BoxLayout layout = new BoxLayout(otherOptions, BoxLayout.Y_AXIS);
//        otherOptions.setLayout(layout);

        for (int b = 0; b <= optionButtons.length - 1; b++) {
            if (b <= 4) {
                if (p.tempDistance < 1) {
                    options.add(optionButtons[b]);
                    optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                    optionButtons[b].setPreferredSize(new Dimension(100, 100));
                    optionButtons[b].addActionListener(this);
                }

            } else {
                otherOptions.add(optionButtons[b]);
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
            JOptionPane.showMessageDialog(null, history(), "Location History", JOptionPane.INFORMATION_MESSAGE, mapIcon);
        } else if (e.getSource() == optionButtons[4]) { // "Inventory"
            game.setVisible(false);
            options.setVisible(false);
            otherOptions.setVisible(false);
            p.tempDistance = 0;
            InventoryWindow backpack = new InventoryWindow(p);
        } else if (e.getSource() == optionButtons[5]) { // "Explore"
            p.playerStats[2]++;
        } else if (e.getSource() == optionButtons[6]) { // "Leave"
            otherOptions.setVisible(false);
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
            otherOptions.setVisible(false);
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
            locationPanel.setVisible(true);
        }

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
