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

    // large hp, medium hp, small hp, beer, donut, croissant
    ArrayList<String> availableConsumables = new ArrayList<>();
    final String CONSUMABLE_NAMES[] = {"Large Health Potion", "Medium Health Potion", "Small Health Potion", "Beer", "Donut", "Croissant"};
    final String CONSUMABLE_SHORT_NAMES[] = {"large", "medium", "small", "b", "d", "cro"};
    int consumables[] = {0, 0, 0, 0, 0, 0};
    final int healAmount[] = {35, 25, 15, 10, 20, 30};
    double starylCoins;
    // lives, health
    int playerStats[] = {5, 100};

    // weapon, pet, armour
    int additionalDamage[] = {0, 0};
    int additionalDefense[] = {0, 0, 0, 0};

    static Gearset gear = new Gearset();

//    void Inventory() { // needs updating to match new consumables
//        boolean backpack = true;
//        while (backpack) {
//            if (consumables != null || gear.amo != null || starylCoins > 0) {
//                System.out.println("Backpack:");
//                if (consumables != null) {
//                    System.out.println("Consumables:");
//                    for (int h = 0; h <= consumables.length - 1; h++) {
//                        if (consumables[h] != 0) {
//                            System.out.println(CONSUMABLE_NAMES[h] + " X " + consumables[h]);
//                        }
//                    }
//                }
//                if (gear.amo != null) {
//                    for (int h = 0; h <= gear.amo.length - 1; h++) {
//                        if (gear.amo[h] != 0) {
//                            System.out.println(gear.AMO_NAMES[h] + " X " + gear.amo[h]);
//                        }
//                    }
//                }
//                if (starylCoins > 0) {
//                    System.out.println("Money");
//                    System.out.println("\nStar Coins X " + starylCoins + ".");
//                }
//                consume();
//            } else {
//                System.out.println("Backpack is empty");
//            }
//            String bpAgain = AdvMain.readLine("Would you like to close your backpack?"); // gives the user the option to stay in the inventory or close it
//            if (bpAgain.equals("yes")) {
//                backpack = false;
//            } else if (bpAgain.equals("no")) {
//            }
//        }
//    }

//    void consume() {
//        ArrayList<String> availableConsumables = new ArrayList<>();
//        boolean foodAvailable = false;
//        for (int c = 0; c <= consumables.length - 1; c++) {
//            if (consumables[c] != 0) {
//                foodAvailable = true;
//            }
//        }
//        if (foodAvailable) {  // gives the user the option to drink one of the health potions
//            boolean bp = true;
//            while (bp) {
//                String backpackAction = AdvMain.readLine("Would you like to eat a consumable?");
//                backpackAction = backpackAction.toLowerCase();
//                if (backpackAction.equals("yes")) {
//                    System.out.println("Which would you like to eat?");
//                    for (int c = 0; c <= CONSUMABLE_NAMES.length - 1; c++) {
//                        if (consumables[c] != 0) {
//                            System.out.println("(" + CONSUMABLE_SHORT_NAMES[c] + ")\t" + CONSUMABLE_NAMES[c]);
//                            availableConsumables.add(CONSUMABLE_SHORT_NAMES[c]);
//                        }
//                    }
//                    String eat = AdvMain.readLine(">");
//                    if (eat.equals(availableConsumables)) {
//                        for (int consume = 0; consume <= availableConsumables.size(); consume++) {
//                            if (eat.equals(availableConsumables.get(consume))) {
//                                playerStats[1] += healAmount[consume];
//                                consumables[consume]--;
//                                System.out.println(healAmount[consume] + " has been added to player health");
//                            }
//                        }
//                    } else {
//                        System.out.println("Invalid Input");
//                    }
//                } else if (backpackAction.equals("no")) {
//                    bp = false;
//                } else {
//                    System.out.println("Invalid Input");
//                }
//            }
//        }
//    }

    String Stats() { // displays statistics
        return "Miles Traveled: " + AdvMain.nDistance +
                "\nLives Remaining: " + playerStats[0] +
                "\nHealth Remaining: " + playerStats[1];

    }

    void arrayReset() {
        for (int i = 0; i <= items.length; i++) {
            items[i] = 0;
        }
        for (int i = 0; i <= gear.armourExp.length - 1; i++) {
            gear.armourExp[i] = 0;
        }
        for (int i = 0; i <= gear.armourUpValue.length; i++) {
            gear.armourUpValue[i] = 0;
        }
        for (int i = 0; i <= gear.weaponStart.length; i++) {
            gear.weapons[i] = gear.weaponStart[i];
        }
        gear.slingshotUpgrade[0] = gear.weaponStart[0];
        gear.macheteUpgrade[0] = gear.weaponStart[1];
        gear.rifleUpgrade[0] = gear.weaponStart[2];
        gear.saberUpgrade[0] = gear.weaponStart[3];
        playerStats[0] = 5;
        playerStats[1] = 100;


    }
}
