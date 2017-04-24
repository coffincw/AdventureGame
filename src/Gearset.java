/**
 * Created by coffincw on 11/24/16.
 */
public class Gearset {

    int weaponClass = 0;

    String armour[] = {"Helmet", "Shirt", "Pants", "Boots"};
    String weapons[] = {"Slingshot", "Machete", "Hunting Rifle", "Saber"};
    String gear[] = {"Helmet", "Shirt", "Pants", "Boots", "Weapon"};

    final String AMO_NAMES[] = {"Pebbles", "Bullets"};
    int amo[] = {0, 0};

    final String weaponStart[] = {"Wooden", "Rusted", "Cricket", "Wooden"};

    //v gear upgrades v

    //armour upgrades
    final String armourUpgrade[] = {"Tin Foil", "Steel", "Ultimate", "Staryl - X"};
    // weapon upgrades
    final String slingshotUpgrade[] = {"Wooden", "Metal", "Guardian", "Staryl - X"};
    final String macheteUpgrade[] = {"Rusted", "Stainless Steel", "Wrath", "Staryl - X"};
    final String rifleUpgrade[] = {"Cricket", "Winchester", "Remington", "Staryl - X"};
    final String saberUpgrade[] = {"Wooden", "Metal", "Darkness", "Staryl - X"};

    int armourUpValue[] = {0, 0, 0, 0}; // level of the weapon
    int armourExp[] = {0, 0, 0, 0}; // exp held by armour

    int weaponUpValue[] = {0, 0, 0, 0}; // level of weapon
    int weaponExp[] = {0, 0, 0, 0}; // exp held by weapon

    String gearInfo() {
        String gear = "";

        for (int g = 0; g <= armour.length - 2; g++) {
            gear += "\n" + armourUpgrade[armourUpValue[g]] + " " + armour[g];
        }
        if (weaponClass == 0) { // slingshot
            gear += "\n" + slingshotUpgrade[weaponUpValue[0]] + " " + weapons[weaponClass];
        } else if (weaponClass == 1) { // machete
            gear += "\n" + macheteUpgrade[weaponUpValue[1]] + " " + weapons[weaponClass];
        } else if (weaponClass == 2) { // rifle
            gear += "\n" + rifleUpgrade[weaponUpValue[2]] + " " + weapons[weaponClass];
        } else if (weaponClass == 3) { // saber
            gear += "\n" + saberUpgrade[weaponUpValue[3]] + " " + weapons[weaponClass];
        }
        return gear;
    }

    void armourLevelUp(Player p) {
        for (int e = 0; e <= armourExp.length - 1; e++) {
            if (armourExp[e] >= 100) {
                armourUpValue[e]++;
                p.additionalDefense[e] += 10;
                System.out.println(armour[e] + " leveled up to: " + armourUpgrade[armourUpValue[e]]);
                armourExp[e] = 0;
            }
        }
        System.out.println();
    }

    void weaponLevelUp(Player p) {
        for (int e = 0; e <= weaponExp.length - 1; e++) {
            if (weaponExp[e] >= 100) {
                if (weaponClass >= 3 && weaponUpValue[e] >= 100) {
                } else {
                    weaponUpValue[e]++;
                    p.additionalDamage[0] += 10;
                    if (weaponClass == 0) {
                        System.out.println("Slingshot level up to " + slingshotUpgrade[weaponUpValue[e]]);
                    } else if (weaponClass == 1) {
                        System.out.println("Machete level up to " + macheteUpgrade[weaponUpValue[e]]);
                    } else if (weaponClass == 2) {
                        System.out.println("Hunting Rifle level up to " + rifleUpgrade[weaponUpValue[e]]);
                    } else if (weaponClass == 3) {
                        System.out.println("Saber leveled up to " + saberUpgrade[weaponUpValue[e]]);
                    }
                    weaponExp[e] = 0;
                }
            }
        }
    }

    void weaponClassUp() {
        for (int c = 0; c <= weaponUpValue.length - 1; c++) {
            if (weaponUpValue[c] > 4) {
                weaponClass++;
                System.out.println("Your " + weapons[weaponClass - 1] + " classed up to " + weapons[weaponClass]);
                weaponUpValue[c] = 0;
                weaponExp[c] = 0;
            }
        }
    }

}
