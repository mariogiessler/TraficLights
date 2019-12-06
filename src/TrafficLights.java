//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.swing.*;
import java.awt.*;

public class TrafficLights extends JFrame {
    private Dot green, red, orange;

    public TrafficLights() {
        this.setTitle("Example");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(130, 400);
        red = new TrafficLights.Dot("red");
        orange = new TrafficLights.Dot("orange");
        green = new TrafficLights.Dot("green");
        this.add(red);
        this.add(orange);
        this.add(green);
        this.setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

//    public static void main(String[] args) {
//        TrafficLights a = new TrafficLights();
//        a.doIt();
//    }

    public void doIt() {
        while (true) {
            for (int i = 1; i < 5; ++i) {
                System.out.println(i);
                switch (i) {
                    case 1:
                        red.deleteColor();
                        orange.deleteColor();
                        green.setColor();
                        break;
                    case 2:
                        green.deleteColor();
                        orange.setColor();
                        break;
                    case 3:
                        orange.deleteColor();
                        red.setColor();
                        break;
                    case 4:
                        orange.setColor();
                }

                repaint();

                try {
                    if (i != 2 && i != 4) {
                        Thread.sleep(5000L);
                    } else {
                        Thread.sleep(1000L);
                    }
                } catch (InterruptedException var3) {
                    var3.printStackTrace();
                }
            }
        }
    }

    public class Dot extends JPanel {
        private Color color;
        private String name;
        private int y;

        public Dot(String name) {
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

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            red.paint(g2);
            orange.paint(g2);
            green.paint(g2);
        }
    }
}
