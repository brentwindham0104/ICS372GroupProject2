package events;

public class PowerOffEvent extends RefrigeratorEvent {
    private PowerOffEvent instance;

    private PowerOffEvent() {

    }

    public PowerOffEvent getInstance() {
        if (instance == null) {
            instance = new PowerOffEvent();
        }

        return instance;
    }
}
