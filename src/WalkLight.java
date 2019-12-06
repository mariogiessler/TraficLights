public class WalkLight extends TrafficLight {
    private Light red, green;

    public WalkLight(String call) {
        super(call);


        red = new Light("red");

        green = new Light("green");

    }
}
