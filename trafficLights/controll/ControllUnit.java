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
        initSequence();
    }

    private static void sequence() {
        while (true) {

            for (int i = 0; i <= 16; i++) {

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
                    case 8:
                        car.killLight("red");
                        car.killLight("orange");
                        car.setLight("green");
                        System.out.println(" Walker: red, Car: green");
                        break;

                    case 13:
                        car.killLight("green");
                        car.setLight("orange");
                        System.out.println(" Walker: red, Car: orange");
                        break;
                    case 14:
                        car.killLight("orange");
                        car.setLight("red");
                        System.out.println(" Walker: red, Car: red");

                        break;
                    case 16:
                        walker.killLight("red");
                        walker.setLight("green");
                        System.out.println(" Walker: green, Car: red");
                        break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                car.repaint();
                walker.repaint();

            }
        }
    }

    private static void initSequence() {
        car.setLight("red");
        walker.setLight("green");
        sequence();
    }
}
