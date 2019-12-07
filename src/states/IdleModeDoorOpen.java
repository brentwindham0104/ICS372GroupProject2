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
     * Request to refrigerator context to handle corresponding state change
     * @param
     *       event the reference for the power off event
     */
    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorOpen.instance());
    }
    
    /**
     * Request to refrigerator context to handle corresponding state change
     * @param
     *      event the reference for the door closed event
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());
    }
    
    /**
     * Request to refrigerator context to handle corresponding state change
     * @param
     *     event the reference for the cooling on event
     */
    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorOpen.instance());
    }
    
    /**
     * Request to Refirgerator State to handle temperature changed event.
     * opening of a door affects the rate at which the temperature increases
     * or decreases.
     * @param
     *       event the event that corresponds to change of temperature
     * 
     */
    @Override
    public void handleEvent(TemperatureChanged event) {
        //if temperature is increasing, opening the door
        //will increase the rate at which the temperature
        //increases, and increase the rate at which the temperature
        //decreases, if temperature is decreasing.
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            Temperature.getInstance().incrementTemperature(1);
        }else{
            Temperature.getInstance().decrementTemperature(1);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}
