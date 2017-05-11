/**
 * Created by caleb on 5/11/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CapitalWindow extends AdvWindow implements ActionListener {

    Player p;
    static private JButton[] changeButtons = {new JButton("Jex"), new JButton("Lana")};

    public CapitalWindow(Player p) {
        this.p = p;
        cityView.currentWindow = 1;
        System.out.println(p.nDistance);
        city = AdvMap.CITY_NAMES[currentRoomIndex];
        p.locationHistory.add(city);

        actions.addBorder(actions, "Actions");
        components();
        mainFrame.add(actions, BorderLayout.AFTER_LAST_LINE);
        cityView.setBackground(Color.GRAY);
        if (p.tempDistance < 1) {
            sidebar.setBackground(Color.WHITE);
            mainFrame.add(sidebar, BorderLayout.EAST);
            sidebar.addBorder(sidebar, "Options");
        }

        mainFrame.add(cityView, BorderLayout.CENTER);


        cityView.addBorder(cityView, city);

        //setting viewable
        cityView.setVisible(true);
        sidebar.setVisible(true);
        actions.setVisible(true);
        mainFrame.setVisible(true);
    }

    void components() {
        GridLayout grid = new GridLayout(8, 8);
        sidebar.setLayout(grid);
//        BoxLayout layout = new BoxLayout(actions, BoxLayout.Y_AXIS);
//        actions.setLayout(layout);

        for (int b = 0; b <= optionButtons.length - 1; b++) {
            if (b <= 4) {
                if (p.tempDistance < 1) {
                    sidebar.add(optionButtons[b]);
                    optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                    optionButtons[b].setPreferredSize(new Dimension(100, 100));
                    optionButtons[b].addActionListener(this);
                }

            } else {
                actions.add(optionButtons[b]);
                optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                optionButtons[b].addActionListener(this);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

    }


}
