/**
 * This class implements the event for Power On
 * @author Brentwindham
 */
package events;

public class PowerOnEvent extends RefrigeratorEvent {
    private static PowerOnEvent instance;

    /**
     * Constructor for PowerOnEvent
     */
    private PowerOnEvent() {

    }

    /**
     * Singleton implementation for PowerOnEvent
     * @return Returns instance of PowerOnEvent
     */
    public static PowerOnEvent getInstance() {
        if (instance == null) {
            instance = new PowerOnEvent();
        }

        return instance;
    }
}
