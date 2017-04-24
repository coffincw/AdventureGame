/**
 * Created by caleb on 4/6/17.
 */
public class City_Capital extends CityElement {

    static NationalBank bank = new NationalBank();

    private final String BUILDING_NAMES[] = {"Office Building" , "Government Building", "Capital Street Bank", "Leave Capital Interior"};
    private final String BUILDING_SHORT_NAMES[] = {"office", "gov", "bank", "leave"};

    @Override
    public void central(Player p) {
        boolean city = true;
        while (city) {
            System.out.println("****CAPITAL*****\nThere are many different locations in the capital which one would you like to enter?\nInput:");
            for (int i = 0; i <= BUILDING_NAMES.length - 1; i++) {
                System.out.println("(" + BUILDING_SHORT_NAMES[i] + ")\t" + BUILDING_NAMES[i]);
            }
            String userInput = AdvMain.readLine(">");
            userInput = userInput.toLowerCase().replaceAll(" ", "");
            if (userInput.equals(BUILDING_SHORT_NAMES[0])) {
                location();
            } else if (userInput.equals(BUILDING_SHORT_NAMES[1])) {
                location2();
            } else if (userInput.equals(BUILDING_SHORT_NAMES[2])) {
                bank.Info(BUILDING_NAMES[2], p);
            } else if (userInput.equals(BUILDING_SHORT_NAMES[3])) {
                city = false;
            } else {}
        }
    }

    @Override
    public void location() {

    }

    public void location2() {

    }
}
