/**
 * Created by coffincw on 12/4/16.
 */
public class MonsterAttack {

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
            System.out.println("The " + monsterName + "'s attack missed!");
        }
        System.out.println("The " + monsterName + " dealt " + dealtDamage + " damage! You now have " + temptempHealth + " health.");
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
