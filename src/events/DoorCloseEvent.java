package events;

public class DoorCloseEvent extends RefrigeratorEvent {
    private static DoorCloseEvent instance;

    private DoorCloseEvent() {

    }

    public static DoorCloseEvent getInstance() {
        if (instance == null) {
            instance = new DoorCloseEvent();
        }

        return instance;
    }
}
