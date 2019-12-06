import javax.swing.*;
import java.awt.*;

public class Light extends JPanel {
    private String name;
    private int y;
    private Color color;

    public Light(String name) {
        this.name = name;
        this.y = this.initY();
        this.color = Color.DARK_GRAY;
    }

    private Color getColor() {
        if (this.name == "red") {
            return Color.red;
        } else {
            return this.name == "orange" ? Color.ORANGE : Color.GREEN;
        }
    }

    public void setColor() {
        this.color = this.getColor();
    }

    public void deleteColor() {
        this.color = Color.DARK_GRAY;
    }

    private int initY() {
        if (this.name == "red") {
            return 10;
        } else {
            return this.name == "orange" ? 130 : 250;
        }
    }

    public void paint(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fillOval(10, this.y, 100, 100);
    }


}

