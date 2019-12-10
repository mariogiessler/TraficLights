package controll;

import lights.CarLight;
import lights.TrafficLight;
import lights.WalkerLight;

import java.awt.*;

public class ControllUnit {

    private static TrafficLight car1, walker2, car2, walker1;

    public static void start() {
        car1 = new CarLight();
        car2 = new CarLight();
        walker2 = new WalkerLight();
        walker1 = new WalkerLight();
        car1.setLocation(new Point(400, 400));
        walker1.setLocation(new Point(600, 450));
        car2.setLocation(new Point(800, 400));
        walker2.setLocation(new Point(1000, 450));
        sequence(); // blank or 'false' for normal Mode / 'true' for blinking
    }

    private static void sequence() {
        car1.setLight("red");
        car2.setLight("green");
        walker1.setLight("red");
        walker2.setLight("green");

        while (true) {

            for (int i = 0; i <= 14; i++) {

                switch (i) {
                    case 4:
                        car2.killLight("green");
                        car2.setLight("orange");
                        walker2.killLight("green");
                        walker2.setLight("red");
                        break;
                    case 5:
                        car2.killLight("orange");
                        car2.setLight("red");
                        break;
                    case 6:
                        car1.setLight("orange");
                        break;
                    case 7:
                        car1.killLight("red");
                        car1.killLight("orange");
                        car1.setLight("green");
                        walker1.killLight("red");
                        walker1.setLight("green");
                        break;


                    case 11:
                        car1.killLight("green");
                        car1.setLight("orange");
                        walker1.killLight("green");
                        walker1.setLight("red");
                        break;
                    case 12:
                        car1.killLight("orange");
                        car1.setLight("red");
                        break;
                    case 13:
                        car2.setLight("orange");
                        break;
                    case 14:
                        car2.killLight("red");
                        car2.killLight("orange");
                        car2.setLight("green");
                        walker2.killLight("red");
                        walker2.setLight("green");
                        break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                car1.repaint();
                car2.repaint();
                walker2.repaint();
                walker1.repaint();

            }
        }
    }

    private static void sequence(Boolean blink) {
        if (!blink) {
            sequence();
        } else {
            // init for blinking
            walker2.killLight("red");
            walker2.killLight("green");
            car1.killLight("red");
            car1.killLight("green");
            walker2.repaint();

            while (true) {
                car1.blink();
                car2.blink();
                car1.repaint();
                car2.repaint();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
