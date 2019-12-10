package Lights;

import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame {
    private Light green, orange, red;

    public TrafficLight() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        red = new Light("red");
        add(red);
        if (this.getClass().getSimpleName().equals("CarLight")) {
            orange = new Light("orange");
            add(orange);
        }
        green = new Light("green");
        add(green);


        setVisible(true);
        setResizable(false);
    }

    public void setLight(String color) {

        if (color.equals("green")) {
            green.set();
        } else if (color.equals("red")) {
            red.set();
        } else {
            if (this.getClass().getSimpleName().equals("CarLight")) {
                orange.set();
            }
        }

    }

    public void killLight(String color) {

        if (color.equals("green")) {
            green.kill();
        } else if (color.equals("red")) {
            red.kill();
        } else {
            if (this.getClass().getSimpleName().equals("CarLight")) {
                orange.kill();
            }
        }

    }
}

