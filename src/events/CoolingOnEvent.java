package events;

public class CoolingOnEvent extends RefrigeratorEvent {
    private CoolingOnEvent instance;

    private CoolingOnEvent() {

    }

    public CoolingOnEvent getInstance() {
        if (instance == null) {
            instance = new CoolingOnEvent();
        }

        return instance;
    }
}
