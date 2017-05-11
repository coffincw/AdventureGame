/**
 * Created by C on 11/15/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/*
Class which have all the information available on the title screen.  It allows the player the see the cityView instructions, score explained, maps and to just start the cityView.
 */
public class TitleScreen extends AdvWindow implements ActionListener {
    AdvPanel titlePanel = new AdvPanel();

    private JButton[] buttonTitle = {new JButton("Start"), new JButton("Instructions"), new JButton("About"), new JButton("Exit")};
    private JLabel[] title = {new JLabel("Carthage")};


    Player p;

    public TitleScreen(Player p) {
        this.p = p;
        titlePanel.currentWindow = 0;

        mainFrame.setTitle("Carthage");
        mainFrame.add(titlePanel);
        titlePanel.setBackground(Color.GRAY);

        //layout
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        //adding pieces
        title[0].setFont(new Font("Old London", Font.PLAIN, 100));
        title[0].setBorder(BorderFactory.createEmptyBorder(150, 30, 150, 30));
        title[0].setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title[0]);

        for (int b = 0; b <= buttonTitle.length - 1; b++) {
            titlePanel.add(buttonTitle[b]);
            buttonTitle[b].setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonTitle[b].addActionListener(this);
        }
        buttonTitle[0].setToolTipText("Click to start your adventure");
        buttonTitle[1].setToolTipText("Click to view how the cityView is played");
        buttonTitle[2].setToolTipText("Click to exit the cityView");

        mainFrame.setVisible(true);
        //  } while (titleScreen);


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == buttonTitle[0]) {
            titlePanel.setVisible(false);
            p.city = "jex";
            GameplayWindow game = new GameplayWindow(p);
        } else if (e.getSource() == buttonTitle[1]) {
            JOptionPane.showMessageDialog(null, gameInstruct(), "Instructions", JOptionPane.QUESTION_MESSAGE);
        } else if (e.getSource() == buttonTitle[2]) {
            JOptionPane.showMessageDialog(null, About(), "About", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == buttonTitle[3]) {
            mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));

        }
    }

    String gameInstruct() {
        return "How to Play:" +
                "\nUse the buttons at the bottom of the screen to" +
                "\nmake decisions which will effect your fate in" +
                "\nCarthage.  While in battle, use the different" +
                "\nsidebar of attack to wound the enemy before" +
                "\nthey best you. Each city and location has there" +
                "\nown pieces you can interact with.  Good Luck" +
                "\nand dont die! ";
    }

    String About() {
        return "Welcome to Carthage, an adventure cityView which" +
                "\nlets you explore different cities and areas while" +
                "\nleveling up your gear and fighting monsters!";
    }
}
