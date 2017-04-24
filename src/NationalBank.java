/**
 * Created by coffincw on 11/27/16.
 */
public class NationalBank extends BuildingElement{

    int planOption;

    static int account[] = {0, 0, 0, 0};
    static final String ACCOUNT_NAMES[] = {"", "Withdraw Anytime", "10 mile Savings Account", "Lifetime Account"};

    void Info(String cityName, Player p) {
        boolean bank = true;
        while (bank) {
            int accountOption = 0;
            while (accountOption < 1){
                try {
                    accountOption = Integer.valueOf(AdvMain.readLine("Welcome to the National Bank in " + cityName + "!\nWhat would you like to do?\nInput:\n<1> deposit\n<2> withdraw\n<3> leave"));
                }
                catch (NumberFormatException ex) {}
            }
            switch (accountOption) {
                case 1:
                    depositInfo(p);
                    break;
                case 2:
                    withdrawInfo();
                    break;
                case 3:
                    bank = false;
                    break;
            }
        }

    }
    void interest() {

    }

    void depositInfo(Player p) {
        planOption = 0;
        while (planOption < 1){
            try {
                planOption = Integer.valueOf(AdvMain.readLine("Which interest plan would you like to choose?" +
                        "\n<1> " + ACCOUNT_NAMES[1] + " (1 coin per mile)" +
                        "\n<2> " + ACCOUNT_NAMES[2] + " (2 coins per mile locked for 10 miles)" +
                        "\n<3> " + ACCOUNT_NAMES[3] + " (5 coins per mile locked for 40 miles)"));
            }
            catch (NumberFormatException ex) {}
        }
        depositAmount(p);
    }

    void depositAmount(Player p) {
        int amount = 0;
        do {
            while (amount < 1){
                try {
                    amount = Integer.valueOf(AdvMain.readLine("Please input the amount you would like to deposit"));
                }
                catch (NumberFormatException ex) {}
            }
            if (amount >= p.items[2]) {
                account[planOption] = amount;
                System.out.println("");
            } else {
                System.out.println("Please input a staryl coin value less than your balance.\nYour balance is: " + p.items[2] + "staryl coins");
            }
        } while (amount <= p.items[2]);
    }


    void withdrawInfo() {

    }

}
