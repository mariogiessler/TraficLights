package controll;

import lights.CarLight;
import lights.TrafficLight;
import lights.WalkerLight;

import java.awt.*;

public class ControllUnit {

    private static TrafficLight car, walker;

    public static void start() {
        car = new CarLight();
        walker = new WalkerLight();
        car.setLocation(new Point(400, 400));
        walker.setLocation(new Point(700, 450));
        sequence(); // blank or 'false' for normal Mode / 'true' for blinking
    }

    private static void sequence() {
        car.setLight("red");
        walker.setLight("green");
        while (true) {

            for (int i = 0; i <= 14; i++) {

                switch (i) {

                    case 5:
                        walker.killLight("green");
                        walker.setLight("red");
                        System.out.println(" Walker: red, Car: red");
                        break;
                    case 6:
                        car.setLight("orange");
                        System.out.println(" Walker: red, Car: orange/red");
                        break;
                    case 7:
                        car.killLight("red");
                        car.killLight("orange");
                        car.setLight("green");
                        System.out.println(" Walker: red, Car: green");
                        break;

                    case 12:
                        car.killLight("green");
                        car.setLight("orange");
                        System.out.println(" Walker: red, Car: orange");
                        break;
                    case 13:
                        car.killLight("orange");
                        car.setLight("red");
                        System.out.println(" Walker: red, Car: red");

                        break;
                    case 14:
                        walker.killLight("red");
                        walker.setLight("green");
                        System.out.println(" Walker: green, Car: red");
                        break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                car.repaint();
                walker.repaint();

            }
        }
    }

    private static void sequence(Boolean blink) {
        if (!blink) {
            sequence();
        } else {
            // init for blinking
            walker.killLight("red");
            walker.killLight("green");
            car.killLight("red");
            car.killLight("green");
            walker.repaint();

            while (true) {
                car.blink();
                car.repaint();

                System.out.println("ATTENTION MODE!!!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
