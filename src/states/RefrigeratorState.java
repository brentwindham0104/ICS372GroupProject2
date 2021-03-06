package states;

import events.*;
import temperature.Temperature;

/**
 * Super class for all states
 * @author Brent
 * 
 *
 */
public abstract class RefrigeratorState {

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state
     */
    public abstract void leave();

    /**
     * Specifies the actions to be taken when power is on.
     */
    public void handleEvent(PowerOnEvent event) {

    }

    /**
     * Specifies the actions to be taken when power is off
     */
    public void handleEvent(PowerOffEvent event) {

    }

    /**
     * Process door open request
     */
    public void handleEvent(DoorOpenEvent event) {

    }
    
    /**
     * Process door close request
     */
    public void handleEvent(DoorCloseEvent event) {

    }

    /**
     * Process TemperatureChanged event
     */
    public void handleEvent(TemperatureChanged event) {
        String outSideTemperature = String.valueOf(Temperature.getInstance().getOutSideTemperature());
        String fridgeTemperature = String.valueOf(Temperature.getInstance().getFridgeTemperature());
        RefrigeratorContext.instance().showInternalTemperature(fridgeTemperature);
        RefrigeratorContext.instance().showExternalTemperature(outSideTemperature);
    }
    
    /**
     * Process cooling engage event
     */
    public void handleEvent(CoolingOnEvent event) {

    }

    /**
     * Process cooling disengage event
     */
    public void handleEvent(CoolingOffEvent event) {

    }

}

