package states;

import display.RefrigeratorDisplay;
import events.CoolingOffEvent;
import events.CoolingOnEvent;
import events.DoorCloseEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;
import events.PowerOnEvent;


/**
 * The context stores the context info for states
 *
 */
public class RefrigeratorContext {
    private RefrigeratorDisplay display;
    private RefrigeratorState currentState;
    private static RefrigeratorContext instance;

    /**
     * Make it a singleton
     */
    private RefrigeratorContext() {
        instance = this;
        currentState = PowerOnDoorClosedCoolingOff.instance();
    }

    /**
     * Return the instance
     * 
     * @return the object
     */
    public static RefrigeratorContext instance() {
        if (instance == null) {
            instance = new RefrigeratorContext();
        }
        return instance;
    }

    //Yet to implement a RefridgeratorDisplay Object
    public void setDisplay(RefrigeratorDisplay display) {
      //TODO
    }

    /**
     * Lets cooling on state be starting state 
     */
    public void initialize() {
        instance.changeState(PowerOnDoorClosedCoolingOn.instance());
    }

    /**
     * Called from the states to change the current state
     * 
     * @param nextState
     *            the next state
     */
    public void changeState(RefrigeratorState nextState) {
        currentState.leave();
        currentState = nextState;
        currentState.enter();
    }
    
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void handleEvent(CoolingOnEvent event) {
        currentState.handleEvent(event);
    };
    
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void handleEvent(CoolingOffEvent event) {
        currentState.handleEvent(event);
    };

    /**
     * Process door close request
     */
    public void handleEvent(DoorCloseEvent event) {
        currentState.handleEvent(event);
    }
    /**
     * Process door open request
     */
    public void handleEvent(DoorOpenEvent event) {
        currentState.handleEvent(event);
    }
  
    /**
     * Process power off request
     */
    public void handleEvent(PowerOffEvent event) {
        currentState.handleEvent(event);
    }
    
    /**
     * Process power on request
     */
    public void handleEvent(PowerOnEvent event) {
        currentState.handleEvent(event);
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showLightOn() {
        display.showLightOn();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showLightOff() {
        display.showLightOff();
    }
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showRefrigeratorOff() {
        display.showRefrigeratorOff();
    }
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showRefrigeratorOn() {
        display.showRefrigeratorOn();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showRefrigeratorCoolingOff() {
        display.showRefrigeratorCoolingOff();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showRefrigeratorCoolingOn() {
        display.showRefrigeratorCoolingOn();
    }

   

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showDoorOpened() {
        display.showDoorOpened();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showDoorClosed() {
        display.showDoorClosed();
    }
    
    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showInternalTemperature() {
        display.showInternalTemperature();
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showExternalTemperature() {
        display.showExternalTemperature();
    }
    
}



