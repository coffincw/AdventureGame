import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Created by caleb on 3/20/17.
 */
public class AdvPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // g.drawString("HELLO WORLD", 10, 150);

        // g.setColor(Color.WHITE);
    }
    public void erase() {
        getGraphics().clearRect(0, 0, getWidth(), getHeight() );
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

    public void drawCicle(int x, int y, int radius) {
        Graphics g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillOval(x, y, radius, radius);
    }
}
