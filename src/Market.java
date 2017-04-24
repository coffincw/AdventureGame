/**
 * Created by coffincw on 11/26/16.
 */
public class Market extends BuildingElement{

    @Override
    void Info(String storeName, Player p) {
        boolean store = true;
        int storeTalk = Integer.valueOf(AdvMain.readLine("Welcome to the " + storeName + "! I hope you find what you need here!\nYou have " + p.items[2] + " coins\n<1> Purchase Items\n<2> Exit " + storeName));
        while (store) {
            switch (storeTalk) {
                case 1:
                    buyItems(p);
                    break;
                case 2:
                    store = false;
                    break;
            }

        }
    }

    void buyItems(Player p) { // main page to buy items
        boolean items = true;
        while (items) {
            int itemChoice = 0;
            while (itemChoice < 1) {
                try {
                    itemChoice = Integer.valueOf(AdvMain.readLine("What would you like to buy:" +
                            "\n<1> Health Potions (2 coins)" +
                            "\n<2> Pebbles (1 coin for 5 pebbles)" +
                            "\n<3> Purchase something else"));

                } catch (NumberFormatException ex) {
                }
            }
            switch (itemChoice) {
                case 1: // purchase health potions
                    buyHeathPotions(p);
                    break;
                case 2: // purchase pebbles
                    buyPebbles(p);
                    break;
                case 3:
                    items = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    void buyHeathPotions(Player p) { // purchase health potions with coins
        if (p.items[2] >= 2) { // makes sure player has enough gold
            p.items[0]++;
            System.out.println("Thank you for buying from us!" +
                    "\n1 Health Potion was added to your backpack" +
                    "\nHealth Potions: " + p.items[0]);
            p.items[2] -= 2; // charges players balance

        } else {
            System.out.println("You do not have enough coins to buy this");
        }
    }

    void buyPebbles(Player p) {  // purchase pebbles (slingshot amo) with coins
        if (p.items[2] >= 1) {
            p.items[1] += 5;
            System.out.println("Thank you for buying from us!" +
                    "\n5x Pebbles was added to your backpack" +
                    "\nPebbles: " + p.items[1]);
            p.items[2]--;

        } else {
            System.out.println("You do not have enough coins to buy this");
        }
    }
}
