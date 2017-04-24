/**
 * Created by caleb on 4/6/17.
 */
public class City_Lana extends CityElement {

    private final String BUILDING_NAMES[] = {"Lana Market", "Sword Gas Station", "Leave Lana Interior"};
    private final String BUILDING_SHORT_NAMES[] = {"market", "gas", "leave"};

    static Market store = new Market();

    @Override
    public void central(Player p) {
        AdvMain.city = true;
        while (AdvMain.city) {
            System.out.println("||Lana||\nWhat location would you like to enter?\nInput:");
            for (int i = 0; i <= BUILDING_NAMES.length - 1; i++) {
                System.out.println("(" + BUILDING_SHORT_NAMES[i] + ")\t" + BUILDING_NAMES[i]);
            }
            String userInput = AdvMain.readLine(">");
            userInput = userInput.toLowerCase().replaceAll(" ", "");
            if (userInput.equals(BUILDING_SHORT_NAMES[0])) {
                store.Info(BUILDING_NAMES[0], p);
            } else if (userInput.equals(BUILDING_SHORT_NAMES[1])) {
                location();
            } else if (userInput.equals(BUILDING_SHORT_NAMES[2])) {
                AdvMain.city = false;
            } else {
            }
        }
    }

    @Override
    public void location() {
        System.out.println("Welcome to Clef's Apartment Building!  I hope you find what you need here!\nWould you like to talk to:\n");
        for (int i = 0; i <= PEOPLE_NAMES.length; i++) {

        }
        String gasTalk = AdvMain.readLine(">");
        gasTalk = gasTalk.toLowerCase();
    }
}
