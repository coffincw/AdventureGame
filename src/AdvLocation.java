/* StarylLocation -- This class represents a single room on the map; a room corresponds to one vertex of a dodecahedron.
 * The class helps in navigating the map and handling encounters when the player moves.
 */

import java.util.ArrayList;
public class AdvLocation {

    int myIndex;
    int[] neighbors;

    public LocationElement myElement;

    AdvLocation(int ndx, int c, int j, int l) {
        myIndex = ndx;
        neighbors = new int [AdvMap.N_LOCATIONS + 1];
        neighbors[AdvMap.CAPITAL] = c;
        neighbors[AdvMap.JEX] = j;
        neighbors[AdvMap.LANA] = l;

    }

    int getIndex() {
        return myIndex;
    }

    LocationElement getElement() {
        return myElement;
    }

    void setElement(LocationElement elem) {
        myElement = elem;
    }

    AdvLocation roomInDirection(int dir) {
        return GameplayWindow.map.getRoom(neighbors[dir]);
    }

    ArrayList<Integer> travel() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= AdvMap.N_LOCATIONS; i++) {
            AdvLocation room = roomInDirection(i);
            if (room != null) {
                arr.add(i);

            }
        }
        return arr;
    }

//    void printInfo() {
//        if (AdvMain.nDistance > 0) {
//            System.out.print("\nWelcome to " + AdvMap.CITY_NAMES[AdvMain.Cityndx].toUpperCase() + ".");
//        } else {
//            System.out.print("\nWelcome to " + AdvMap.CITY_NAMES_RESHUFFLED[AdvMain.currentRoomIndex].toUpperCase() + ".");
//
//        }
//        System.out.println("\nInput:" +
//                "\n(g) Gear Info" +
//                "\n(s) Stats" +
//                "\n(m)	Map" +
//                "\n(b)	Backpack" +
//                "\n(l)	Leave location" +
//                "\n(e)	explore town\n");
//        for (int i = 1; i <= AdvMap.N_LOCATIONS; i++) {
//            AdvLocation room = roomInDirection(i);
//            if (room != null && room.myElement != null) {
//                room.myElement.printSenses();
//            }
//        }
//
//        System.out.println();
//    }

    void handleElement() {
        if (myElement != null) {
            myElement.handle();
        }
    }
}
