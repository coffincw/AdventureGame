/**
 * Created by caleb on 4/6/17.
 */
public class City_Jex extends CityElement {

    static TrainingCenter training = new TrainingCenter();

    private final String BUILDING_NAMES[] = {"Jasmines Market", "Jex Training Center", "Leave Jex Interior"};
    private final String BUILDING_SHORT_NAMES[] = {"market", "train", "leave"};


    @Override
    public void central(Player p) {
        boolean city = true;
        while (city) {
            System.out.println("<<Jex>>\nWhich location would you like to enter?\nInput:");
            for (int i = 0; i <= BUILDING_NAMES.length - 1; i++) {
                System.out.println("(" + BUILDING_SHORT_NAMES[i] + ")\t" + BUILDING_NAMES[i]);
            }
            String userInput = AdvMain.readLine(">");
            userInput = userInput.toLowerCase().replaceAll(" ", "");
            if (userInput.equals(BUILDING_SHORT_NAMES[0])) {
                location();
            } else if (userInput.equals(BUILDING_SHORT_NAMES[1])) {
                training.Info(BUILDING_NAMES[1], p);
            } else if (userInput.equals(BUILDING_SHORT_NAMES[2])) {
                city = false;
            } else {}
        }
    }

    @Override
    public void location() {

    }
}
