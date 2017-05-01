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

    static AdvMap map = new AdvMap();

    Player p;
    private ImageIcon mapIcon = options.createImageIcon("Thumbtack.png");
    private ImageIcon gearIcon = options.createImageIcon("gear.png");
    private ImageIcon statsIcon = options.createImageIcon("stats.png");

    private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};

    public GameplayWindow(Player p, boolean change) {

        this.p = p;
        game.currentWindow = 1;

        game.setBackground(Color.GRAY);
        options.setBackground(Color.WHITE);

        mainFrame.add(game, BorderLayout.CENTER);
        mainFrame.add(options, BorderLayout.EAST);


        //adding borders
        otherOptions.addBorder(otherOptions, "Actions");
        options.addBorder(options, "Options");

        components(change);
        mainFrame.add(otherOptions, BorderLayout.AFTER_LAST_LINE);


        mainFrame.setVisible(true);

    }


    void components(boolean change) {
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
                if (!change) {
                    otherOptions.add(optionButtons[b]);
                    optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                    optionButtons[b].addActionListener(this);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionButtons[0]) {
            JOptionPane.showMessageDialog(null, p.Stats(), "Stats", JOptionPane.INFORMATION_MESSAGE, statsIcon);
        } else if (e.getSource() == optionButtons[1]) {
            JOptionPane.showMessageDialog(null, p.gear.gearInfo(), "Gear", JOptionPane.INFORMATION_MESSAGE, gearIcon);
        } else if (e.getSource() == optionButtons[2]) {
            JOptionPane.showMessageDialog(null, map(), "Map", JOptionPane.INFORMATION_MESSAGE, mapIcon);
        } else if (e.getSource() == optionButtons[3]) {
            game.setVisible(false);
            options.setVisible(false);
            InventoryWindow backpack = new InventoryWindow(p);
        } else if (e.getSource() == optionButtons[4]) {
            p.playerStats[2]++;
        } else if (e.getSource() == optionButtons[5]) {
            //GameplayWindow game = new GameplayWindow(p, change);
        }


    }

    String map() { // displays a print out version of map
        return "                                                     " +
                "\n    (Jex) ---- (Capital) ---- (Lana)           " +
                "\n                                                     ";
    }

    public void changeLocation() {
//        map.getRoom(currentRoomIndex).printTravel();
//        String travel = readLine("\nWhere would you like to travel to? (Enter: (explore) or (e) to stay in current location)");
//        travel = travel.toLowerCase();
//        int direction = 0;
//        if ((direction = AdvMap.directionNumber(travel)) != 0) {
//            nDistance += 1;
//            Cityndx = AdvMap.directionNumber(travel);
//            AdvLocation nowRoom = map.getRoom(currentRoomIndex);
//            AdvLocation targetRoom = nowRoom.roomInDirection(direction);
//            if (targetRoom != null) {
//                currentRoomIndex = targetRoom.getIndex();
//                targetRoom.handleElement();
//            } else {
//                System.out.println("You can't move in that direction.");
//            }
//        }
    }
}
