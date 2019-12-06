import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame {

    private CarLight carLight;
    private WalkLight walkLight;

    public TrafficLight(String call) {
        setBackground(Color.BLACK);
        switch (call) {
            case "car":
                setTitle("Car");
                carLight = new CarLight();
                add(carLight);
                break;
            case "walker":
                setTitle("Walker");
                carLight = new CarLight();
                add(carLight);
                break;
        }
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }


}
