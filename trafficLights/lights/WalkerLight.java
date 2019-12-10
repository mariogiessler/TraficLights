package lights;

import java.awt.*;

public class WalkerLight extends TrafficLight {


    public WalkerLight() {
        setTitle("Walker");
        setSize(140, 300);
        getContentPane().setLayout(new GridLayout(2, 1));
    }
}
