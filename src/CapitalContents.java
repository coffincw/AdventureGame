import javax.swing.*;
import java.awt.*;

/**
 * Created by caleb on 5/17/17.
 */
public class CapitalContents extends AdvWindow {


    public CapitalContents(Player p) {
        mainFrame.add(cityView, BorderLayout.CENTER);
        cityView.addBorder(cityView, p.city);
        GridLayout cityGrid = new GridLayout(0, 6);
        cityGrid.setHgap(10);
        cityGrid.setVgap(2);
        cityView.setLayout(cityGrid);
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.addImage(cityView, "house.png");
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.addImage(cityView, "bank.png");
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.addImage(cityView, "house.png");
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.add(new JLabel(""));
        cityView.addImage(cityView, "house.png");
        cityGrid.layoutContainer(cityView);
    }
}
