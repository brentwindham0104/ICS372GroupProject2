package events;

public class DoorCloseEvent extends RefrigeratorEvent {
    private DoorCloseEvent instance;

    private DoorCloseEvent() {

    }

    public DoorCloseEvent getInstance() {
        if (instance == null) {
            instance = new DoorCloseEvent();
        }

        return instance;
    }
}
