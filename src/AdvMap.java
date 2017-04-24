/**
 * Created by caleb on 3/30/17.
 */

/* AdvMap -- This class represents the entire game map.  The vertices of a dodecahedron are the locations and the edges
 * are the connections between locations.
 */

public class AdvMap {

    static final int N_LOCATIONS = 3;
    static final int CAPITAL = 1;
    static final int JEX = 2;
    static final int LANA = 3;

    static City_Capital capital = new City_Capital(); //train , bank
    static City_Jex jex = new City_Jex(); //training center
    static City_Lana lana = new City_Lana(); // store


    final static String[] CITY_NAMES = {"", "capital", "jex", "lana"};
    final static String[] EXPLORABLE_DESTINATIONS = {"", "capital", "jex", "lana"};
    final static String[] CITY_SHORT_NAMES = {"", "cap", "j", "la"};
    final static String[] CITY_NAMES_RESHUFFLED = {"", "capital", "jex", "lana"};


    static AdvLocation[] locations;

    AdvMap() {
        locations = new AdvLocation[N_LOCATIONS + 1];
        locations[1] =  new AdvLocation(1, 0, 2, 3); // v Crossroad ## v
        locations[2] =  new AdvLocation(2, 1, 0, 0);
        locations[3] =  new AdvLocation(3, 1, 0, 0);

    }


    static String locationName(int dir) {
// change this to add direction
        if (dir >= 1 && dir <= 4)
            return CITY_NAMES[dir];
        else
            return "ERROR";
    }

    static int directionNumber(String dir) {
        for (int i = 1; i <= N_LOCATIONS; i++) {
            if (CITY_NAMES[i].equals(dir) ||
                    CITY_SHORT_NAMES[i].equals(dir)) {
                return i;
            }
        }
        return 0;

    }

    AdvLocation getRoom(int ndx) {
        return locations[ndx];
    }

    int randomCity() {
        int r = 0;
        do {
            r = (int) (Math.random() * N_LOCATIONS + 1);
        }
        while (locations[r].getElement() != null);
        return r;
    }

    void enterCity(int ndx, Player p) {
        switch (ndx) {
            case 1:
                capital.central(p);
                break;
            case 2:
                jex.central(p);
                break;
            case 3:
                lana.central(p);
                break;
        }
    }

    void addElement(LocationElement elem) {getRoom(randomCity()).setElement(elem);}

    // remove and replace element in random position
    // locations[i].setElement(null);
    // addElement(new ---());

}
