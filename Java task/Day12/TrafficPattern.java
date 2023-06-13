class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        state = new RedState(this);
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void performAction() {
        state.performAction();
    }
}

interface TrafficLightState {
    void performAction();
}


class RedState implements TrafficLightState {
    private final TrafficLight trafficLight;

    public RedState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void performAction() {
        System.out.println("Stop. Light is red.");
        trafficLight.setState(new GreenState(trafficLight));
    }
}

class GreenState implements TrafficLightState {
    private final TrafficLight trafficLight;

    public GreenState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void performAction() {
        System.out.println("Go. Light is green.");
        trafficLight.setState(new YellowState(trafficLight));
    }
}

class YellowState implements TrafficLightState {
    private final TrafficLight trafficLight;

    public YellowState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void performAction() {
        System.out.println("Prepare to stop. Light is yellow.");
        trafficLight.setState(new RedState(trafficLight));
    }
}
public class TrafficPattern{
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.performAction(); 
        trafficLight.performAction(); 
        trafficLight.performAction();
        trafficLight.performAction(); 
    }
}
