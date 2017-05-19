/**
 * Created by caleb on 4/7/17.
 */
public class Monster extends MonsterOrganization {

    void spawnMonster(int monsterIndex, int[] monsterhealthArray, String[] monsterNames, int possiblemonsterDMG_lowest, int possiblemonsterDMG_highest, Player p) {

        p_attack.attack = 0;
        while (monsterhealthArray[monsterIndex] > 0 && p.playerStats[0] > 0) {
            p_attack.playerAttack(monsterNames[monsterIndex], monsterIndex, monsterhealthArray, training, p);
            if (monsterhealthArray[monsterIndex] > 0) {
                m_attack.mAttack(monsterNames[monsterIndex], AdvMain.randomInt(possiblemonsterDMG_lowest, possiblemonsterDMG_highest), test);
            }
        }
        if (monsterhealthArray[0] <= 0) {
            System.out.println("You defeated the " + monsterNames[monsterIndex] + " with " + p.playerStats[0] + " lives remaining!");
            expWon(monsterIndex, p);
        } else if (p.playerStats[0] <= 0) {
            System.out.println("You were defeated by the " + monsterNames[monsterIndex] + " who had " + monsterhealthArray[monsterIndex] + " health remaining.");
        }
        resetMonsterHealth();
    }

    void resetMonsterHealth() {
        for (int r = 0; r <= monsterHealth.length - 1; r++) {
            monsterHealth[r] = MONSTER_HEALTH_START[r];
        }
    }

}
