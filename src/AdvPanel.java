import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.image.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by caleb on 3/20/17.
 */
public class AdvPanel extends JPanel {

    int currentWindow;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentWindow == 1) {
            switch (Player.city) {
                case "capital":
                    ImageIcon capitalTitle = createImage("capital_title.png");
                    capitalTitle.paintIcon(this, g, -58, -60);
                    // drawCircle(g, 11, 11, 25);


                    break;
                case "inner_capital":
                    ImageIcon capitalBackground = createImage("capital_background_new.png");
                    capitalBackground.paintIcon(this, g, 0, 0);

                    break;
                case "jex":
                    ImageIcon jexTitle = createImage("jex_title.png");
                    jexTitle.paintIcon(this, g, -58, -60);
                    break;
                case "inner_jex":
                    ImageIcon jexBackground = createImage("jex_background.png");
                    jexBackground.paintIcon(this, g, 0, 0);
                    break;
                case "lana":
                    ImageIcon lanaTitle = createImage("lana_title.png");
                    lanaTitle.paintIcon(this, g, -58, -60);
                    break;
                case "inner_lana":
                    ImageIcon lanaBackground = createImage("lana_background.png");
                    lanaBackground.paintIcon(this, g, 0, 0);
                    break;
            }

        }
//
//         g.drawString("HELLO WORLD", 10, 150);
//
//         g.setColor(Color.WHITE);
    }

    JLabel addBackground(String imagePath) {
        JLabel contentPane = new JLabel();
        contentPane.setIcon(createImage(imagePath));
        contentPane.setLayout(new BorderLayout());
        return contentPane;
    }

    ImageIcon createImage(String imagePath) {
        ImageIcon image = new ImageIcon(this.getClass().getResource(imagePath));
        return image;
    }


    public void erase() {
        getGraphics().clearRect(0, 0, getWidth(), getHeight());
    }

    void addSidebar(AdvPanel panel, int rep) {

    }

    void addBorder(AdvPanel panel, String borderTitle) {
        TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), borderTitle);
        panel.setBorder(title);
    }

    static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = AdvWindow.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void drawRandomCircle() {
        int width = getWidth();
        int height = getHeight();
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        int radius = (int) (Math.random() * (width - x));
        Graphics g = getGraphics();

        g.setColor(new Color((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)));
        g.fillOval(x, y, radius, radius);

    }

    //public void paint(Graphics g) {
    //g.fillOval(11, 11, 25, 25);
    //}

    public void drawCircle(Graphics g, int x, int y, int radius) {

        g.setColor(Color.BLACK);
        g.fillOval(x, y, radius, radius); //FOR CIRCLE

    }
}
