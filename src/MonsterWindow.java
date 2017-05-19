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

    AdvPanel fight = new AdvPanel();
    AdvPanel actions = new AdvPanel();

    Player p;

    public MonsterWindow(int monsterIndex, int[] monsterhealthArray, String[] monsterNames, int possiblemonsterDMG_lowest, int possiblemonsterDMG_highest, Player p) {
        this.p = p;
        cityView.currentWindow = 3;

        mainFrame.add(appear(monsterIndex, monsterNames), BorderLayout.CENTER);


        actions.addBorder(actions, "Actions");
        //components();

        mainFrame.add(actions, BorderLayout.AFTER_LAST_LINE);
        fight.setBackground(Color.GRAY);

        mainFrame.add(fight, BorderLayout.CENTER);


        //

        //setting viewable

        fight.setVisible(true);
        actions.setVisible(true);
        mainFrame.setVisible(true);

        p.m.spawnMonster(monsterIndex, monsterhealthArray, monsterNames, possiblemonsterDMG_lowest, possiblemonsterDMG_highest, p);

    }

    JPanel appear(int monsterIndex, String[] monsterNames) {
        JPanel appearPanel = new JPanel();
        JLabel appear = new JLabel("Suddenly, a " + monsterNames[monsterIndex] + " approaches...");
        appear.setFont(new Font("Old London", Font.PLAIN, 100));
        appear.setBorder(BorderFactory.createEmptyBorder(150, 30, 150, 30));
        appear.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton[] decisionButtons = {new JButton("Fight"), new JButton("Attempt to Flee")};
        for (int i = 0; i < decisionButtons.length; i++) {
            appearPanel.add(decisionButtons[i]);
            decisionButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            decisionButtons[i].addActionListener(this);
        }
        appearPanel.add(appear);
        appearPanel.setVisible(true);
        return appearPanel;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
