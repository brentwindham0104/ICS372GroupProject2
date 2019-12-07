/**
 * This class implements the event for DoorClose.
 *
 * @author Brentwindham
 */
package events;

public class DoorCloseEvent extends RefrigeratorEvent {
    private static DoorCloseEvent instance;

    /**
     * Constructor for DoorCloseEvent.
     */
    private DoorCloseEvent() {

    }

    /**
     * Singleton implementation for DoorClose
     * @return Returns instance of DoorCloseEvent
     */
    public static DoorCloseEvent getInstance() {
        if (instance == null) {
            instance = new DoorCloseEvent();
        }

        return instance;
    }
}
