package states;

import events.CoolingOnEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;
/**
 * Represents the state of refrigerator powered on with door closed
 * and not cooling.
 * @author Brent
 *
 */
public class IdleModeDoorClosed extends RefrigeratorState{
    private static IdleModeDoorClosed instance;
    
    /**
     * Private for the singleton pattern
     */
    private IdleModeDoorClosed(){

    }
    
    /**
     * For singleton
     * 
     * @return the object
     */
    public static IdleModeDoorClosed instance(){
        if(instance==null){
            instance = new IdleModeDoorClosed();
        }
        return instance;
    }
    
    /**
     * 
     * Updates indicators on GUI display to refelect the current state. The method 
     * enter() is tasked with completing initialization requirements.
     * 
     */
    @Override
    public void enter() {
            RefrigeratorContext.instance().showRefrigeratorOn();
            RefrigeratorContext.instance().showDoorClosed();
            RefrigeratorContext.instance().showRefrigeratorCoolingOff();
            RefrigeratorContext.instance().showLightOff();
    }
    
    /**
     * 
     * Updates indicators on GUI display to refelect the current state. The method 
     * leave() is tasked with completing exiting clean up.
     * 
     */
    @Override
    public void leave() {

    }
    
    /**
     * Request to refrigerator context to handle corresponding state change
     * @param
     *        event the reference for the power off event.
     */
    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorClosed.instance());

    }
    
    /**
     * Request to refrigerator context to handle corresponding state change
     * @param
     *        event the reference for the door open event.
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorOpen.instance());

    }
   
    /**
     * Request to refrigerator context to handle corresponding state change
     * @param
     *       event   the reference for the cooling on event.
     */
    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorClosed.instance());

    }
}
