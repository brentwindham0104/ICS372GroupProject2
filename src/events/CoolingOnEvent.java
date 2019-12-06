/**
 * This class implements the event for Cooling On.
 * @author brentwindham
 */
package events;

public class CoolingOnEvent extends RefrigeratorEvent {
    private static CoolingOnEvent instance;

    /**
     * Constructor for CoolingOnEvent
     */
    private CoolingOnEvent() {

    }

    /**
     * Singleton implementation for CoolingOnEvent
     * @return Returns the instance for CoolingOn
     */
    public static CoolingOnEvent getInstance() {
        if (instance == null) {
            instance = new CoolingOnEvent();
        }

        return instance;
    }
}
