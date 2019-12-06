package events;

public class CoolingOffEvent extends RefrigeratorEvent {
    private static CoolingOffEvent instance;

    private CoolingOffEvent() {

    }

    public static CoolingOffEvent getInstance() {
        if (instance == null) {
            instance = new CoolingOffEvent();
        }

        return instance;
    }
}
