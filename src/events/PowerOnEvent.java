package events;

public class PowerOnEvent extends RefrigeratorEvent {
    private PowerOnEvent instance;

    private PowerOnEvent() {

    }

    public PowerOnEvent getInstance() {
        if (instance == null) {
            instance = new PowerOnEvent();
        }

        return instance;
    }
}
