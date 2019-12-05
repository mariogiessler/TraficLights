import java.awt.*;

import javax.swing.*;

class Car extends JPanel {

    private Dot green, red, orange;
    private JFrame main;

    public Car() {
        main = new JFrame();
        main.setTitle("Car");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(130, 400);

        red = new Dot("red");
        orange = new Dot("orange");
        green = new Dot("green");

        main.setBackground(Color.BLACK);
        main.add(red);
        main.add(green);
        main.add(orange);

        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setResizable(false);

    }

    public static void main(String[] args) {
        Car a = new Car();
        Car b = new Car();
        a.doIt();
    }

    public void doIt() {
        while (true) {
            for (int i = 1; i < 5; i++) {
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
                        break;
                }
                repaint();
                try {
                    if (i == 2 || i == 4) {
                        Thread.sleep(1000);
                    } else {
                        Thread.sleep(10000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        red.paint(g2);
        orange.paint(g2);
        green.paint(g2);
    }
}

class Dot extends JPanel {
    private Color color;
    private String name;
    private int y;

    public Dot(String name) {

        this.name = name;
        this.y = initY();
        this.color = Color.DARK_GRAY;
    }

    private Color getColor() {
        if (this.name == "red") {
            return Color.red;
        } else if (this.name == "orange") {
            return Color.ORANGE;
        }
        return Color.GREEN;
    }

    public void setColor() {
        this.color = getColor();
    }

    public void deleteColor() {
        this.color = Color.DARK_GRAY;
    }

    private int initY() {
        if (this.name == "red") {
            return 10;
        } else if (this.name == "orange") {
            return 130;
        }
        return 250;
    }

    public void paint(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fillOval(10, this.y, 100, 100);
    }

}


