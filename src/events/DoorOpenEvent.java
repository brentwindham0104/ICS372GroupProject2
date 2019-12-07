/**
 * This class implements the event for Door open.
 * @author Brentwindham
 */
package events;

public class DoorOpenEvent extends RefrigeratorEvent {
    private static DoorOpenEvent instance;

    /**
     * Constructor for DoorOpenEvent
     */
    private DoorOpenEvent() {

    }

    /**
     * Singleton implementation for DoorOpenEvent
     * @return Returns instance of DoorOpenEvent
     */
    public static DoorOpenEvent getInstance() {
        if (instance == null) {
            instance = new DoorOpenEvent();
        }

        return instance;
    }
}
