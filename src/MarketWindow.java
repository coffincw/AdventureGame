import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by caleb on 5/24/17.
 */
public class MarketWindow extends AdvWindow implements ActionListener {

    Player p;

    int[] cost = {};

    public MarketWindow(Player p) {
        //get month names
        SpinnerModel model =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        p.items[2] / cost[0], //max
                        1);
        JSpinner spinner = new JSpinner(model);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
