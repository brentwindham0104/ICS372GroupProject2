package states;

import events.CoolingOnEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

/**
 * Represents the state of refrigerator powered on with door opened
 * and not cooling.
 *
 */
public class IdleModeDoorOpen extends RefrigeratorState{
    private static IdleModeDoorOpen instance;
    
    /**
     * Private for the singleton pattern
     */
    private IdleModeDoorOpen(){

    }
    
    /**
     * For singleton
     * 
     * @return the object
     */
    public static IdleModeDoorOpen instance(){
        if(instance==null){
            instance = new IdleModeDoorOpen();
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
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOn();
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
     * Request to refrigerator context to handle power off event
     */
    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorOpen.instance());
    }
    
    /**
     * Request to refrigerator context to handle door close event
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());
    }
    
    /**
     * Request to refrigerator context to handle cooling on event
     */
    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorOpen.instance());
    }
    
    /**
     * Request to RefirgeratorState to handle temperature changed event. 
     * 
     */
    @Override
    public void handleEvent(TemperatureChanged event) {
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            Temperature.getInstance().incrementTemperature(1);
        }else{
            Temperature.getInstance().decrementTemperature(1);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}
