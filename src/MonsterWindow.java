import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by caleb on 5/19/17.
 */
public class MonsterWindow extends AdvWindow implements ActionListener {

    static AdvPanel fight = new AdvPanel();
    static AdvPanel actions = new AdvPanel();

    Player p;

    int monsterIndex;
    int[] monsterhealthArray;
    String[] monsterNames;
    int possiblemonsterDMG_lowest;
    int possiblemonsterDMG_highest;


    JButton[] decisionButtons = {new JButton("Fight"), new JButton("Attempt to Flee")};

    public MonsterWindow(int monsterIndex, int[] monsterhealthArray, String[] monsterNames, int possiblemonsterDMG_lowest, int possiblemonsterDMG_highest, Player p) {
        this.p = p;
        this.monsterIndex = monsterIndex;
        this.monsterhealthArray = monsterhealthArray;
        this.monsterNames = monsterNames;
        this.possiblemonsterDMG_lowest = possiblemonsterDMG_lowest;
        this.possiblemonsterDMG_highest = possiblemonsterDMG_highest;

        cityView.currentWindow = 3;

        mainFrame.add(appear(), BorderLayout.CENTER);


        mainFrame.setVisible(true);

        //p.m.spawnMonster(monsterIndex, monsterhealthArray, monsterNames, possiblemonsterDMG_lowest, possiblemonsterDMG_highest, p);

    }

    JPanel appear() {
        JPanel appearPanel = new JPanel();
        appearPanel.setLayout(new BoxLayout(appearPanel, BoxLayout.Y_AXIS));
        JLabel appear = new JLabel("Suddenly, a " + monsterNames[monsterIndex] + " approaches...");
        appear.setFont(new Font("Old London", Font.PLAIN, 50));
        appear.setBorder(BorderFactory.createEmptyBorder(150, 30, 150, 30));
        appear.setAlignmentX(Component.CENTER_ALIGNMENT);
        appearPanel.add(appear);


        for (int i = 0; i < decisionButtons.length; i++) {
            appearPanel.add(decisionButtons[i]);
            decisionButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            decisionButtons[i].setAlignmentY(Component.CENTER_ALIGNMENT);
            decisionButtons[i].addActionListener(this);

        }

        appearPanel.setVisible(true);
        return appearPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == decisionButtons[0]) { // "fight"
            mainFrame.remove(appear());
            appear().setVisible(false);
            initiateFight();

        } else if (e.getSource() == decisionButtons[1]) { // "attempt to flee"
            mainFrame.remove(appear());
            appear().setVisible(false);
            int chance = AdvMain.randomInt(0, 3);
            System.out.println("chance:" + chance);
            if (chance == 1) {
                GameplayWindow game = new GameplayWindow(p);
            } else {
                System.out.println("test");
                initiateFight();
            }
        }
    }

    void initiateFight() {
        actions.addBorder(actions, "Actions");
        actions.setBackground(Color.white);
        //components();


        fight.setBackground(Color.GRAY);
        mainFrame.add(fight);
        mainFrame.add(actions, BorderLayout.AFTER_LAST_LINE);


        //setting viewable

        fight.setVisible(true);
        actions.setVisible(true);
    }

    void components() {

    }

}
