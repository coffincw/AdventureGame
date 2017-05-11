import java.util.ArrayList;

/**
 * Created by block7 on 11/4/16.
 */

/*
Player class which holds the inventory, maps, statistics, score and highscore call.
 */
public class Player {

    // Health Potions, Pebbles, coins
    int items[] = {0, 0, 0}; // split into arrays: health potions, ammo, currency?

    String city;

    // large hp, medium hp, small hp, beer, donut, croissant
    final String CONSUMABLE_NAMES[] = {"Large Health Potion", "Medium Health Potion", "Small Health Potion", "Beer", "Donut", "Croissant"};
    int consumables[] = {2, 5, 7, 0, 8, 0};
    int testConsumables[] = {0, 0, 0, 0, 0, 0};
    final int healAmount[] = {35, 25, 15, 10, 20, 30};

    ArrayList<String> locationHistory = new ArrayList<>();
    int nDistance;
    int tempDistance;


    // lives, health
    int playerStats[] = {5, 100, 0};

    // weapon, pet, armour
    int additionalDamage[] = {0, 0};
    int additionalDefense[] = {0, 0, 0, 0};

    static Gearset gear = new Gearset();

    String Stats() { // displays statistics
        return "Miles Traveled: " + playerStats[2] +
                "\nLives Remaining: " + playerStats[0] +
                "\nHealth Remaining: " + playerStats[1];

    }

    String map() { // displays a print out version of map
        return "                                                     " +
                "\n    (Jex) ---- (Capital) ---- (Lana)           " +
                "\n                                                     ";
    }

    String history() {
        String his = "";
        for (String i : locationHistory) {
            his += " " + i + "\n";
        }
        return his;
    }

//    void arrayReset() {
//        for (int i = 0; i <= items.length; i++) {
//            items[i] = 0;
//        }
//        for (int i = 0; i <= gear.armourExp.length - 1; i++) {
//            gear.armourExp[i] = 0;
//        }
//        for (int i = 0; i <= gear.armourUpValue.length; i++) {
//            gear.armourUpValue[i] = 0;
//        }
//        for (int i = 0; i <= gear.weaponStart.length; i++) {
//            gear.weapons[i] = gear.weaponStart[i];
//        }
//        gear.slingshotUpgrade[0] = gear.weaponStart[0];
//        gear.macheteUpgrade[0] = gear.weaponStart[1];
//        gear.rifleUpgrade[0] = gear.weaponStart[2];
//        gear.saberUpgrade[0] = gear.weaponStart[3];
//        playerStats[0] = 5;
//        playerStats[1] = 100;
//
//
//    }
}
