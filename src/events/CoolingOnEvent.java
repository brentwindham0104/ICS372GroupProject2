package events;

public class CoolingOnEvent extends RefrigeratorEvent {
    private static CoolingOnEvent instance;

    private CoolingOnEvent() {

    }

    public static CoolingOnEvent getInstance() {
        if (instance == null) {
            instance = new CoolingOnEvent();
        }

        return instance;
    }
}
