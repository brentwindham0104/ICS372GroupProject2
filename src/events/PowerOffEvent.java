/**
 * This class implements the event for Power Off.
 *
 * @author Brentwindham
 */
package events;

public class PowerOffEvent extends RefrigeratorEvent {
    private static PowerOffEvent instance;

    /**
     * Constructor for PowerOffEvent
     */
    private PowerOffEvent() {

    }

    /**
     * Singleton implementation for PowerOffEvent
     * @return Returns instance of PowerOffEvent
     */
    public static PowerOffEvent getInstance() {
        if (instance == null) {
            instance = new PowerOffEvent();
        }

        return instance;
    }
}
