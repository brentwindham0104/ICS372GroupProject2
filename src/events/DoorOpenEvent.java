package events;

public class DoorOpenEvent extends RefrigeratorEvent {
    private DoorOpenEvent instance;

    private DoorOpenEvent() {

    }

    public DoorOpenEvent getInstance() {
        if (instance == null) {
            instance = new DoorOpenEvent();
        }

        return instance;
    }
}
