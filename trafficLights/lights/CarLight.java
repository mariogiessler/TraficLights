package lights;

import java.awt.*;

public class CarLight extends TrafficLight {


    public CarLight() {
        setTitle("Car");
        setSize(140, 430);
        getContentPane().setLayout(new GridLayout(3, 1));
    }
}
