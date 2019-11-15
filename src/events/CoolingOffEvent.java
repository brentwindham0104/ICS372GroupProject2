package events;

public class CoolingOffEvent extends RefrigeratorEvent {
    private CoolingOffEvent instance;

    private CoolingOffEvent() {

    }

    public CoolingOffEvent getInstance() {
        if (instance == null) {
            instance = new CoolingOffEvent();
        }

        return instance;
    }
}
