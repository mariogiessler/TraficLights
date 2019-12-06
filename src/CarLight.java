import javax.swing.*;
import java.awt.*;

public class CarLight extends JPanel {
    private JFrame frame;
    public Light red, orange, green;

    public CarLight() {


        red = new Light("red");
        orange = new Light("orange");
        green = new Light("green");
        this.setSize(800, 600);
        this.add(red);


    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        red.paint(g2);
        orange.paint(g2);
        green.paint(g2);


    }


}
