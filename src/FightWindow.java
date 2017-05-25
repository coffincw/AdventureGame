import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by caleb on 5/22/17.
 */
public class FightWindow extends AdvWindow implements ActionListener {

    static AdvPanel fight = new AdvPanel();
    private static AdvPanel moves = new AdvPanel();
    private static AdvPanel leave = new AdvPanel();

    static PlayerAttack p_attack = new PlayerAttack();
    static MonsterAttack m_attack = new MonsterAttack();

    boolean test = false;
    boolean training = false;

    private boolean repeatAttack;
    private int percentHit;
    private int tempDamage;
    int attack;
    private int poison;

    private Gearset gear = new Gearset();

    JButton step[] = {new JButton("Next"), new JButton("Next"), new JButton("Next")};

    private final int percentNeck[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private final int percentEyes[] = {0, 1, 2, 3, 4};
    private final int percentChest[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18};

    private final JButton attackMonster[] = {new JButton("neck"), new JButton("eyes"), new JButton("chest")};
    private final JButton fightButtons[] = {new JButton("Next"), new JButton("Leave")};


    final static String MONSTER_NAMES[] = {"Giv", "Kar", "Perrkill", "Turtower"};
    static int monsterHealth[] = {40, 50, 30, 60};
    final static int MONSTER_HEALTH_START[] = {40, 50, 30, 60};
    final static int monsterExp[] = {10, 15, 5, 20};
    final int monsterDefense[] = {3, 10, 1, 20};

    int monsterIndex;

    Player p;

    public FightWindow(int monsterIndex, int possiblemonsterDMG_lowest, int possiblemonsterDMG_highest, Player p) {
        this.p = p;
        this.monsterIndex = monsterIndex;
        moves.addBorder(actions, "Actions");
        moves.setBackground(Color.white);
        //components();


        fight.setBackground(Color.GRAY);
        mainFrame.add(fight, BorderLayout.CENTER);
        System.out.println("i");
        mainFrame.add(moves, BorderLayout.AFTER_LAST_LINE);


        //setting viewable

        fight.setVisible(true);
        moves.setVisible(true);
        spawnMonster(possiblemonsterDMG_lowest, possiblemonsterDMG_highest);

    }

    void expWon(int monsterIndex, Player p) {
        int random = AdvMain.randomInt(0, 4);
        for (int i = 0; i <= gear.gear.length; i++) {
            if (random == i) {
                if (i == 4) {
                    gear.weaponExp[gear.weaponClass] += monsterExp[monsterIndex];
                    System.out.println(gear.gear[i] + " experience increased by " + monsterExp[monsterIndex]);
                    gear.weaponLevelUp(p);
                    gear.weaponClassUp();
                } else {
                    gear.armourExp[i] += monsterExp[monsterIndex];
                    System.out.println(gear.gear[i] + " experience increased by " + monsterExp[monsterIndex]);
                    gear.armourLevelUp(p);
                }

            }
        }

    }


    void spawnMonster(int possiblemonsterDMG_lowest, int possiblemonsterDMG_highest) {

        attack = 0;
        percentHit = AdvMain.randomInt(0, 20);
        tempDamage = 0;
        repeatAttack = true;
//        while (monsterHealth[monsterIndex] > 0 && p.playerStats[0] > 0) {
        for (int a = 0; a <= attackMonster.length - 1; a++) {
            moves.add(attackMonster[a]);
            attackMonster[a].setAlignmentX(Component.CENTER_ALIGNMENT);
            attackMonster[a].addActionListener(this);
            //System.out.println("(" + attackMonster[a] + ")");
        }
//            p_attack.playerAttack(MONSTER_NAMES[monsterIndex], monsterIndex, monsterHealth, training, p);
//            if (monsterHealth[monsterIndex] > 0) {
//                m_attack.mAttack(MONSTER_NAMES[monsterIndex], AdvMain.randomInt(possiblemonsterDMG_lowest, possiblemonsterDMG_highest), test);
//            }
        if (monsterHealth[monsterIndex] > 0 && p.playerStats[0] > 0) {
            fight.add(result());
            resetMonsterHealth();
            mainFrame.remove(actions);
            actions.setVisible(false);
            leave.setBackground(Color.WHITE);
            fightButtons[1].setAlignmentX(Component.CENTER_ALIGNMENT);
            fightButtons[1].addActionListener(this);
            leave.add(fightButtons[1]);
            mainFrame.add(leave);
        }


    }

    JLabel result() {
        JLabel label = new JLabel("");
        if (monsterHealth[monsterIndex] <= 0) {

            label = new JLabel("You defeated the " + MONSTER_NAMES[monsterIndex] + " with " + p.playerStats[0] + " lives remaining!");
            expWon(monsterIndex, p);
        } else if (p.playerStats[0] <= 0) {
            label = new JLabel("You were defeated by the " + MONSTER_NAMES[monsterIndex] + " who had " + monsterHealth[monsterIndex] + " health remaining.");
        }

        return label;
    }

    void resetMonsterHealth() {
        for (int r = 0; r <= monsterHealth.length - 1; r++) {
            monsterHealth[r] = MONSTER_HEALTH_START[r];
        }
    }

    private void hitNeck(int[] percentN, int playerDamage) {
        for (int p = 0; p <= percentN.length - 1; p++) {
            if (percentHit == percentN[p]) { // 60% hit percentage
                tempDamage = playerDamage; // change this for nontraining battle (currently not implemented for weapon upgrades)
            }
        }
        if (tempDamage == 0) {
            fight.add(attackMissed());
        }
        attack += 1;
        repeatAttack = false;
    }

    private void hitEyes(int[] percentE, int playerDamage) {
        for (int p = 0; p <= percentE.length - 1; p++) {
            if (percentHit == percentE[p]) { // 20% hit percentage
                tempDamage = playerDamage; // change this for nontraining battle
            }
        }
        if (tempDamage == 0) {
            fight.add(attackMissed());
        }
        attack += 1;
        repeatAttack = false;
    }

    private void hitChest(int[] percentC, int playerDamage) {

        for (int p = 0; p <= percentC.length - 1; p++) {
            if (percentHit == percentC[p]) { // 90% hit percentage
                tempDamage = playerDamage; // change this for nontraining battle
            }
        }
        if (tempDamage == 0) {
            fight.add(attackMissed());
        }
        attack += 1;
        System.out.println(poison);
        repeatAttack = false;
    }

    private JLabel attackMissed() {
        attack += 0;
        JLabel attackMissed = new JLabel("Your attack missed!");
        return attackMissed;
    }

    private int attackAddition(int damageRange, Player p) {
        int damage = 0;
        damage = damageRange;
        for (int a = 0; a <= p.additionalDamage.length - 1; a++) {
            damage += p.additionalDamage[a];
        }
        poison = machetePoison();
        damage += poison;
        damage -= monsterDefense[monsterIndex];
        return damage;
    }

    int machetePoison() {
        int poison = 0;
        if (gear.weaponClass == 1 && attack != 0) {
            int poisonProbability = AdvMain.randomInt(1, 5);
            if (poisonProbability == 1) {
                poison = AdvMain.randomInt(5, 10);
            }
        }
        return poison;
    }

    void dealDamage() {
        monsterHealth[monsterIndex] -= tempDamage;
        if (monsterHealth[monsterIndex] < 0) {
            monsterHealth[monsterIndex] = 0;
        }
        fight.add(new JLabel("You dealt " + tempDamage + " to the " + MONSTER_NAMES[monsterIndex] + "! the " + MONSTER_NAMES[monsterIndex] + " has " + monsterHealth[monsterIndex] + " health remaining."));

        System.out.println(poison);

        if (poison != 0) {
            fight.add(new JLabel("The " + MONSTER_NAMES[monsterIndex] + " was hurt by your machete's poison blade"));
        }
        for (int i = 0; i < attackMonster.length; i++) {
            moves.remove(attackMonster[i]);
        }

        moves.add(step[0]);
        step[0].setAlignmentX(Component.CENTER_ALIGNMENT);
        step[0].addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        if (actionEvent.getSource() == attackMonster[0]) {
            hitNeck(percentNeck, attackAddition(AdvMain.randomInt(20, 40), p));
            dealDamage();
        } else if (actionEvent.getSource() == attackMonster[1]) {
            hitEyes(percentEyes, attackAddition(AdvMain.randomInt(40, 60), p));
            dealDamage();
        } else if (actionEvent.getSource() == attackMonster[2]) {
            hitChest(percentChest, attackAddition(AdvMain.randomInt(10, 20), p));
            dealDamage();
        } else if (actionEvent.getSource() == step[1]) {
            mainFrame.remove(moves);
            mainFrame.remove(fight);
            moves.setVisible(false);
            fight.setVisible(false);
            //AdvMain.randomInt(possiblemonsterDMG_lowest, possiblemonsterDMG_highest)
            spawnMonster(10, 10);
            //left off here
        }
    }
}
