/**
 * Created by coffincw on 11/30/16.
 */
public class MonsterOrganization {

    static PlayerAttack p_attack = new PlayerAttack();
    static Gearset gear = new Gearset();
    static MonsterAttack m_attack = new MonsterAttack();

    boolean test = false;
    boolean training = false;


    final static String MONSTER_NAMES[] = {"Giv", "Kar", "Perrkill", "Turtower"};
    static int monsterHealth[] = {40, 50, 30, 60};
    final static int MONSTER_HEALTH_START[] = {40, 50, 30, 60};
    final static int monsterExp[] = {10, 15, 5, 20};
    final int monsterDefense[] = {3, 10, 1, 20};

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

}
