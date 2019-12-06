package states;

import display.RefrigeratorDisplay;
import events.*;
import temperature.Temperature;


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
        Temperature.getInstance();
        instance = this;
        currentState = OffModeDoorOpen.instance();

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

    
    public void setDisplay(RefrigeratorDisplay display){
        this.display = display;
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
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     *
     */
    public void setDesiredTemp(int temp) {
        Temperature.getInstance().setDesiredTemperature(temp);
    }


    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     *
     */
    public void setOutsideTemp(int value) {
        Temperature.getInstance().setOutSideTemperature(value);
    }



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

    public void handleEvent(TemperatureChanged event) {
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
    public void showInternalTemperature(String string) {
        display.showInternalTemperature(string);
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showExternalTemperature(String string) {
        display.showExternalTemperature(string);
    }

    public void showDesiredTemperature(String string){
        display.showDesiredTemperature(string);
    }
    
}



