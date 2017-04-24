/**
 * Created by coffincw on 11/27/16.
 */
public class TrainingCenter extends BuildingElement {

    static Gearset gear = new Gearset();
    static PlayerAttack p_attack = new PlayerAttack();
    static MonsterAttack m_attack = new MonsterAttack();

    final int monsterDMGLOW[] = {0, 10, 20};
    final int monsterDMGHIGH[] = {10, 20, 30};
    final String Monster[] = {"Findlewumper", "Gorp", "Calark"}; // monster names
    final int trainingMH[] = {70, 120, 100}; // monster health
    private final String trainGear[] = {"helmet", "shirt", "pants", "boots", "weapon"}; // trainable gear
    int nRounds; //round number
    int nRounds_Final; //round number in order to stop rounds as being counted as completed when player died in them.
    boolean training = true; // this may make it always be true
    int tempHeath = 100;
    boolean monstercheck;
    boolean trainrepeat;

    @Override
    void Info(String centerName, Player p) {
        trainrepeat = true;
        while (trainrepeat) {
            System.out.println("Welcome to " + centerName + ".  The training center is a place where you have an opportunity to train in order to level up your armour." +
                    "\nBe aware, the training center only allows you to work on a piece of armour every 30 miles you travel, so choose wisely." +
                    "\nWhat piece of equipment would you like to work on?");
            gear.gearInfo();
            System.out.println("\nInput:");
            for (int t = 0; t <= trainGear.length - 1; t++) {
                System.out.println(trainGear[t]);
            }
            String train = AdvMain.readLine(">");
            train = train.toLowerCase();
            catchMaxUpgrade(train, p);

        }
    }

    void initiateTraining(String trainObject, int trainingGearndx, Player p) {
        nRounds = 0;
        training = true;
        System.out.println("Welcome to training! You will go through 4 fighting simulators inorder to level up your gear");
        while (nRounds <= 3) {
            nRounds++;
            tempHeath = 100;
            monstercheck = true;
            if (nRounds == 1) {
                spawnTrainingMonster(0, p);
            } else if (nRounds == 2) {
                spawnTrainingMonster(1, p);
            } else if (nRounds == 3) {
                spawnTrainingMonster(2, p);
            }
        }
        int experienceEarned;
        if (trainObject.equals(trainGear[4])) {
            gear.weaponExp[gear.weaponClass] += experienceEarned = (nRounds_Final * 25);
        } else {
            gear.armourExp[trainingGearndx] += experienceEarned = (nRounds_Final * 25);
        }

        System.out.println("You completed " + nRounds_Final + " rounds congrats!\nYou earned " + experienceEarned + " for your " + trainObject);
        gear.armourLevelUp(p);
        gear.weaponLevelUp(p);
        gear.weaponClassUp();
        training = false;
    }

    void spawnTrainingMonster(int monsterIndex, Player p) {
        System.out.println("A " + Monster[monsterIndex] + " approaches...");
        while (trainingMH[monsterIndex] > 0 && tempHeath > 0) {
            p_attack.playerAttack(Monster[monsterIndex], monsterIndex, trainingMH, training, p);
            if (trainingMH[monsterIndex] > 0) {
                m_attack.mAttack(Monster[monsterIndex], AdvMain.randomInt(monsterDMGLOW[monsterIndex], monsterDMGHIGH[monsterIndex]), monstercheck);
            }
            monstercheck = false;
        }
        if (trainingMH[0] <= 0) {
            System.out.println("You defeated the " + Monster[monsterIndex] + " with " + m_attack.temptempHealth + " health remaining!");

        } else if (tempHeath <= 0) {
            System.out.println("You were defeated by the " + Monster[monsterIndex] + " who had " + trainingMH[monsterIndex] + " health remaining.");
            nRounds_Final = nRounds - 1;
            nRounds = 4;

        }
    }

    void catchMaxUpgrade(String trainingItem, Player p) {
        for (int ti = 0; ti <= trainGear.length - 1; ti++) {
            if (trainingItem.equals(trainGear[ti])) {
                if (ti == 4) {
                    if (gear.weaponUpValue[4] >= 4 && gear.weaponExp[4] >= 100) {
                        System.out.println("Sorry this item is maxed out and cant be trained.\n");
                    } else {
                        initiateTraining(trainGear[ti], ti, p);
                        trainrepeat = false;
                    }
                } else {
                    if (gear.armourUpValue[ti] >= 4 && gear.armourExp[ti] >= 100) {
                        System.out.println("Sorry this item is maxed out and cant be trained.\n");
                    } else {
                        initiateTraining(trainGear[ti], ti, p);
                        trainrepeat = false;
                    }
                }

            }
        }
    }


}
