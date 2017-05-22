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


    AdvPanel appearPanel = new AdvPanel();

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

        mainFrame.add(appearPanel, BorderLayout.CENTER);
        appear();


        mainFrame.setVisible(true);

        //p.m.spawnMonster(monsterIndex, monsterhealthArray, monsterNames, possiblemonsterDMG_lowest, possiblemonsterDMG_highest, p);

    }

    void appear() {
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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == decisionButtons[0]) { // "fight"
            for (int i = 0; i < decisionButtons.length; i++) {
                appearPanel.remove(decisionButtons[i]);


            }
            //mainFrame.remove(appearPanel);
            appearPanel.setVisible(false);
            System.out.println("testing");
            initiateFight();

        } else if (e.getSource() == decisionButtons[1]) { // "attempt to flee"

            //mainFrame.remove(appearPanel);
            appearPanel.setVisible(false);
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


    }

    void components() {

    }

}
