package lights;

import javax.swing.*;
import java.awt.*;


public class Light extends JPanel {

    private Color col;
    private Color offColor;
    private String name;
    private boolean isOn;


    public Light(String color) {
        setMaximumSize(new Dimension(120, 120));
        setBounds(10, 10, 90, 90);
        setOpaque(true);
        setBackground(Color.BLACK);

        this.name = color;
        this.offColor = Color.DARK_GRAY;
        setCol();
    }

    private void setCol() {

        if (this.name.equals("green")) {
            this.col = Color.GREEN;

        } else if (this.name.equals("orange")) {
            this.col = Color.ORANGE;

        } else if (this.name.equals("red")) {
            this.col = Color.RED;

        }
    }

    private Color getStatusColor() {
        return isOn ? this.col : this.offColor;
    }

    public void toggle() {
        this.isOn = !this.isOn;
    }


    public void set() {
        this.isOn = true;
    }

    public void kill() {
        this.isOn = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getStatusColor());
        g2.fillOval(10, 10, 110, 110);
    }
}
