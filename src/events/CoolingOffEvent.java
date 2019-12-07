/**
 * This class implements the Event for cooling off.
 * @author Brentwindham
 */
package events;

public class CoolingOffEvent extends RefrigeratorEvent {
    private static CoolingOffEvent instance;

    /**
     * Constructor for CoolingOffEvent
     */
    private CoolingOffEvent() {

    }

    /**
     * This is the method that implements the singleton pattern.
     * @return Returns the instance of CoolingOffEvent
     */
    public static CoolingOffEvent getInstance() {
        if (instance == null) {
            instance = new CoolingOffEvent();
        }

        return instance;
    }
}
