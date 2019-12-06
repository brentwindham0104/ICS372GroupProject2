package events;

public class PowerOnEvent extends RefrigeratorEvent {
    private static PowerOnEvent instance;

    private PowerOnEvent() {

    }

    public static PowerOnEvent getInstance() {
        if (instance == null) {
            instance = new PowerOnEvent();
        }

        return instance;
    }
}
