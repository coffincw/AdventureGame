import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

// Fix training (0 rounds, 0 experience when completed) remove experience awarded during training

/**
 * Created by caleb on 3/30/17.
 */
public class AdvMain {

    static AdvMap map = new AdvMap();
    static Monster m = new Monster();

    static int nDistance;
    //pick map
    static int chooseMap;
    static int turn = 0;

    static int Cityndx;

    //loops
    static String reEdit;
    static boolean city;
    static boolean replayFull;

    public static int currentRoomIndex = 1;


    static String readLine(String prompt) {
        System.out.println(prompt);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int randomInt(int min, int max) { //generates a random integer between the two parameters
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    static void End() {
        // Console asks if player wants to play again
        String replay = readLine("Play again? (yes) or (no)");
        replay = replay.toLowerCase();
        if (replay.equals("no")) {
            replayFull = false;
        }
    }

    public static void main(String[] args) {

        Player p = new Player();
        AdvWindow mainWindow = new AdvWindow();

        replayFull = true; // play again boolean
//        do {
            turn = 0; // for armour experience
//            spawn.nRTT = 0; //for item spawn
            int gamemodeTitle = 0;
        TitleScreen title = new TitleScreen(p);
        //GameplayWindow GP = new GameplayWindow();

        //currentRoomIndex = map.randomCity();

//            do {
//                if (nDistance > 2) {
//                    if (randomInt(1, 4) == randomInt(1, 4)) {
//                        int monsterndx = randomInt(0, 3);
//                        m.spawnMonster(monsterndx, m.monsterHealth, m.MONSTER_NAMES, 10, 30);
//                    }
//                }
//                // prints info
//                map.getRoom(currentRoomIndex).printInfo();
//
//                String userInput = readLine(">");
//                userInput = userInput.toLowerCase();
//                if (userInput.equals("s") || userInput.equals("stats")) {
//                    p.Stats();
//                } else if (userInput.equals("g") || userInput.equals("gear info")) {
//                    p.gear.gearInfo(1);
//                } else if (userInput.equals("m") || userInput.equals("map")) {
//                    seemaps.fullMap();
//                } else if (userInput.equals("b") || userInput.equals("backpack") || userInput.equals("inventory")) {
//                    p.Inventory();
//                } else if (userInput.equals("e") || userInput.equals("explore")) {
//                    map.enterCity(currentRoomIndex);
//                } else if (userInput.equals("l") || userInput.equals("leave")) {
//                    map.getRoom(currentRoomIndex).printTravel();
//                    String travel = readLine("\nWhere would you like to travel to? (Enter: (explore) or (e) to stay in current location)");
//                    travel = travel.toLowerCase();
//                    int direction = 0;
//                    if ((direction = AdvMap.directionNumber(travel)) != 0) {
//                        nDistance += 1;
//                        Cityndx = AdvMap.directionNumber(travel);
//                        AdvLocation nowRoom = map.getRoom(currentRoomIndex);
//                        AdvLocation targetRoom = nowRoom.roomInDirection(direction);
//                        if (targetRoom != null) {
//                            currentRoomIndex = targetRoom.getIndex();
//                            targetRoom.handleElement();
//                        } else {
//                            System.out.println("You can't move in that direction.");
//                        }
//                    } else if (travel.equals("bye")) {
//                        p.playerStats[0] = 0;
//                    } else {
//                        System.out.println("Command not understood");
//                    }
//                } else if (userInput.equals("e") || userInput.equals("explore")) {
//                    // org.cityOrganization(currentRoomIndex);
//                } else if (userInput.equals("bye")) {
//                    p.playerStats[0] = 0;
//                } else {
//                    System.out.println("Command not understood.");
//                }
//            } while (p.playerStats[0] > 0);
//            End();
//            p.arrayReset();
//
//        } while (replayFull);


    }
}
