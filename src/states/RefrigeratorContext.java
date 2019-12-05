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
        currentState = IdlingModeDoorClosed.instance();
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

    /**
     * The display could change. So we have to get its reference.
     * 
     * @param display
     *            The current display object
     */
    public void setDisplay(RefrigeratorDisplay display) {
        this.display = display;
    }


    /**
     * Lets cooling on state be starting state 
     */
    public void initialize() {
        instance.changeState(CoolingModeDoorClosed.instance());
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
     * NOTE: If Dave implements the temperature simulation functionality
     * all methods titled tempCalculate below should be discarded.
     * 
     * When the current state is "CoolingModeDoorOpen" State this method will be called
     * every second the clock ticks. 
     * 
     * This method is supposed to have a math functions which takes as input 
     * the outside temp, inside temp, the goal temp.
     * The method then updates the refrigerator GUI display with the new internal temp.
     */
    public void tempCalculate(TempContext tempContext, CoolingModeDoorOpen currentState) { 
  	  int newTemp = 0;
  	  
  	  /* 
  	   * Math equation goes here, You can access all current temps
  	   * via tempContex.getExternalTemp(), tempContext.getInternalTemp()
  	   * or tempContext.getGoalTemp() methods of the tempContext class.
  	   * 
  	   * input the three temps into your function and then display 
  	   * the resulting temp value. Send the new temp to be displayed
  	   * via the "display.showInternalTemperature()" method below.
  	   */
 	  
  	  
  	  /*
  	   * Math function goes here
  	   */
  	  
  	  display.showInternalTemp(newTemp);
  }
    
    /**
     * When the current state is "CoolingModeDoorShut" State this method will be called
     * every second the clock ticks. 
     * 
     * This method is supposed to have a math functions which takes as input 
     * the outside temp, inside temp, the goal temp.
     * The method then updates the refrigerator GUI display with the new internal temp.
     */
    public void tempCalculate(TempContext tempContext, CoolingModeDoorClosed currentState) { 
  	  int newTemp = 0;
  	  
  	  /* 
  	   * Math equation goes here, You can access all current temps
  	   * via tempContex.getExternalTemp(), tempContext.getInternalTemp()
  	   * or tempContext.getGoalTemp() methods of the tempContext class.
  	   * 
  	   * input the three temps into your function and then display 
  	   * the resulting temp value. Send the new temp to be displayed
  	   * via the "display.showInternalTemperature()" method below.
  	   */
 	  
  	  
  	  /*
  	   * Math function goes here
  	   */
  	  
  	  display.showInternalTemp(newTemp);
  }
    /**
     * When the current state is "IdlingModeDoorOpen" State this method will be called
     * every second the clock ticks. 
     * 
     * This method is supposed to have a math functions which takes as input 
     * the outside temp, inside temp, the goal temp.
     * The method then updates the refrigerator GUI display with the new internal temp.
     */
    public void tempCalculate(TempContext tempContext, IdlingModeDoorOpen currentState) { 
  	  int newTemp = 0;
  	  
  	 /* 
  	   * Math equation goes here, You can access all current temps
  	   * via tempContex.getExternalTemp(), tempContext.getInternalTemp()
  	   * or tempContext.getGoalTemp() methods of the tempContext class.
  	   * 
  	   * input the three temps into your function and then display 
  	   * the resulting temp value. Send the new temp to be displayed
  	   * via the "display.showInternalTemperature()" method below.
  	   */
 	  
  	  
  	  /*
  	   * Math function goes here
  	   */
  	  
  	  display.showInternalTemp(newTemp);
  	}
    
    /**
     * When the current state is "IdlingModeDoorClosed" State this method will be called
     * every second the clock ticks. 
     * 
     * This method is supposed to have a math functions which takes as input 
     * the outside temp, inside temp, the goal temp.
     * The method then updates the refrigerator GUI display with the new internal temp.
     */
    public void tempCalculate(TempContext tempContext, IdlingModeDoorClosed currentState) { 
  	  int newTemp = 0;
  	  
  	 /* 
  	   * Math equation goes here, You can access all current temps
  	   * via tempContex.getExternalTemp(), tempContext.getInternalTemp()
  	   * or tempContext.getGoalTemp() methods of the tempContext class.
  	   * 
  	   * input the three temps into your function and then display 
  	   * the resulting temp value. Send the new temp to be displayed
  	   * via the "display.showInternalTemperature()" method below.
  	   */	  
  	  
  	  /*
  	   * Math function goes here
  	   */
 
  	  display.showInternalTemp(newTemp);
  	}
    
    /**
     * When the current state is "OffModeDoorOpen" State this method will be called
     * every second the clock ticks. 
     * 
     * This method is supposed to have a math functions which takes as input 
     * the outside temp, inside temp, the goal temp.
     * The method then updates the refrigerator GUI display with the new internal temp.
     */
    public void tempCalculate(TempContext tempContext, OffModeDoorOpen currentState) { 
  	  int newTemp = 0;
  	  
  	 /* 
  	   * Math equation goes here, You can access all current temps
  	   * via tempContex.getExternalTemp(), tempContext.getInternalTemp()
  	   * or tempContext.getGoalTemp() methods of the tempContext class.
  	   * 
  	   * input the three temps into your function and then display 
  	   * the resulting temp value. Send the new temp to be displayed
  	   * via the "display.showInternalTemperature()" method below.
  	   */	  
  	  
  	  /*
  	   * Math function goes here
  	   */
  	  
  	  display.showInternalTemp(newTemp);
    }
    /**
     * When the current state is "OffModeDoorClosed" State this method will be called
     * every second the clock ticks. 
     * 
     * This method is supposed to have a math functions which takes as input 
     * the outside temp, inside temp, the goal temp.
     * The method then updates the refrigerator GUI display with the new internal temp.
     */
    public void tempCalculate(TempContext tempContext, OffModeDoorClosed currentState) { 
  	  int newTemp = 0;
  	  
  	 /* 
  	   * Math equation goes here, You can access all current temps
  	   * via tempContex.getExternalTemp(), tempContext.getInternalTemp()
  	   * or tempContext.getGoalTemp() methods of the tempContext class.
  	   * 
  	   * input the three temps into your function and then display 
  	   * the resulting temp value. Send the new temp to be displayed
  	   * via the "display.showInternalTemperature()" method below.
  	   */	  
  	  
  	  /*
  	   * Math function goes here
  	   */
  	  
  	  display.showInternalTemp(newTemp);
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
    public void showInternalTemp(int value) {
        display.showInternalTemp(value);
    }

    /**
     * This invokes the right method of the display. This helps protect the
     * states from changes to the way the system utilizes the state changes.
     * 
     */
    public void showExternalTemp(int value) {
        display.showExternalTemp(value);
    }
    
}



