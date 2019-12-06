package events;

public class DoorOpenEvent extends RefrigeratorEvent {
    private static DoorOpenEvent instance;

    private DoorOpenEvent() {

    }

    public static DoorOpenEvent getInstance() {
        if (instance == null) {
            instance = new DoorOpenEvent();
        }

        return instance;
    }
}
