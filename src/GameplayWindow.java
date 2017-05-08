import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by caleb on 4/15/17.
 */
public class GameplayWindow extends AdvWindow implements ActionListener {

    AdvPanel game = new AdvPanel();
    AdvPanel options = new AdvPanel();
    AdvPanel otherOptions = new AdvPanel();

    static int currentRoomIndex = 1;
    static int Cityndx;

    int nDistance;

    static AdvMap map = new AdvMap();

    Player p;
    private ImageIcon mapIcon = options.createImageIcon("Thumbtack.png");
    private ImageIcon gearIcon = options.createImageIcon("gear.png");
    private ImageIcon statsIcon = options.createImageIcon("stats.png");

    private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};
    private JButton[] changeButtons = {new JButton("Capital"), new JButton("Jex"), new JButton("Lana"), new JButton("Back to Town")};

    public GameplayWindow(Player p) {

        this.p = p;
        game.currentWindow = 1;

        otherOptions.addBorder(otherOptions, "Actions");
        components();
        mainFrame.add(otherOptions, BorderLayout.AFTER_LAST_LINE);
        game.setBackground(Color.GRAY);
        options.setBackground(Color.WHITE);
        mainFrame.add(game, BorderLayout.CENTER);
        mainFrame.add(options, BorderLayout.EAST);
        options.addBorder(options, "Options");
        mainFrame.setVisible(true);


    }


    void components() {
        GridLayout grid = new GridLayout(8, 8);
        options.setLayout(grid);
//        BoxLayout layout = new BoxLayout(otherOptions, BoxLayout.Y_AXIS);
//        otherOptions.setLayout(layout);

        for (int b = 0; b <= optionButtons.length - 1; b++) {
            if (b <= 3) {

                options.add(optionButtons[b]);
                optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                optionButtons[b].setPreferredSize(new Dimension(100, 100));
                optionButtons[b].addActionListener(this);

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
        } else if (e.getSource() == optionButtons[3]) { // "Inventory"
            game.setVisible(false);
            options.setVisible(false);
            otherOptions.setVisible(false);
            InventoryWindow backpack = new InventoryWindow(p);
        } else if (e.getSource() == optionButtons[4]) { // "Explore"
            p.playerStats[2]++;
        } else if (e.getSource() == optionButtons[5]) { // "Leave"
            otherOptions.setVisible(false);
            GameplayWindow game = new GameplayWindow(p);
        } else if (e.getSource() == changeButtons[0]) { // "Capital"
            changeLocation("capital");
        } else if (e.getSource() == changeButtons[1]) { // "Jex"
            changeLocation("jex");
        } else if (e.getSource() == changeButtons[2]) { // "Lana"
            changeLocation("lana");
        } else if (e.getSource() == changeButtons[3]) { // "Back to Town"
            otherOptions.setVisible(false);
            GameplayWindow game = new GameplayWindow(p);
        }
    }

    void locationPanel() {
        for (int b = 0; b <= changeButtons.length - 1; b++) {

        }
    }

    String map() { // displays a print out version of map
        return "                                                     " +
                "\n    (Jex) ---- (Capital) ---- (Lana)           " +
                "\n                                                     ";
    }

    public void changeLocation(String travel) {
        map.getRoom(currentRoomIndex).printTravel();
        int direction = 0;
        if ((direction = AdvMap.directionNumber(travel)) != 0) {
            nDistance += 1;
            Cityndx = AdvMap.directionNumber(travel);
            AdvLocation nowRoom = map.getRoom(currentRoomIndex);
            AdvLocation targetRoom = nowRoom.roomInDirection(direction);
            if (targetRoom != null) {
                currentRoomIndex = targetRoom.getIndex();
                targetRoom.handleElement();
            } else {
                System.out.println("You can't move in that direction.");
            }
        }
    }
}
