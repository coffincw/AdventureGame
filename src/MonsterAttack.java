import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by coffincw on 12/4/16.
 */
public class MonsterAttack implements ActionListener {

    int temptempHealth;
    private int dealtDamage;


    private static TrainingCenter training = new TrainingCenter();


    void mAttack(String monsterName, int monsterdmgValue, boolean checkmonster) {
        if (checkmonster) {
            training.tempHeath = 100;
        }
        if (training.training) {
            ifTraining(monsterdmgValue);
        } else {
            ifNormal(monsterdmgValue);
        }
        if (monsterdmgValue == 0) {
            JLabel monsterMiss = new JLabel("The " + monsterName + "'s attack missed!");
            MonsterWindow.fight.add(monsterMiss);
        }
        JLabel monsterDMG = new JLabel("The " + monsterName + " dealt " + dealtDamage + " damage! You now have " + temptempHealth + " health.");
        MonsterWindow.fight.add(monsterDMG);
    }

    private int defenseAddition(Player p) {
        int defense = 0;
        for (int a = 0; a <= p.additionalDefense.length - 1; a++) {
            defense += p.additionalDefense[a];
        }
        return defense;
    }

    private void ifTraining(int monsterdmgValue) {
        dealtDamage = monsterdmgValue;
        training.tempHeath -= monsterdmgValue;
        if (training.tempHeath < 0) {
            training.tempHeath = 0;
        }
        temptempHealth = training.tempHeath;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    private void ifNormal(int monsterdmgValue) {
//        System.out.println(starylMain.gameDiff);
//        dealtDamage = (monsterdmgValue + defenseAddition());
//        if (dealtDamage < 0) {
//            dealtDamage = 0;
//        }
//        p.playerHealth[starylMain.gameDiff] -= dealtDamage;
//        if (p.playerHealth[starylMain.gameDiff] <= 0) {
//            p.playerLives[starylMain.gameDiff]--;
//            System.out.println("You lost a life");
//            p.playerHealth[starylMain.gameDiff] = p.healPHealth[starylMain.gameDiff];
//        }
    }
}
