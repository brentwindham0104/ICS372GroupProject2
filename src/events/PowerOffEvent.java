package events;

public class PowerOffEvent extends RefrigeratorEvent {
    private static PowerOffEvent instance;

    private PowerOffEvent() {

    }

    public static PowerOffEvent getInstance() {
        if (instance == null) {
            instance = new PowerOffEvent();
        }

        return instance;
    }
}
