package states;

import events.CoolingOffEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

/**
 * Represents the state of cooling with the door opened.
 *
 */
public class CoolingModeDoorOpen extends RefrigeratorState{
    private static CoolingModeDoorOpen instance;
    
    /**
     * Private for the singleton pattern
     */
    private CoolingModeDoorOpen(){

    }
    
    /**
     * For singleton
     * 
     * @return the object
     */
    public static CoolingModeDoorOpen instance(){
        if(instance==null){
            instance = new CoolingModeDoorOpen();
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
        RefrigeratorContext.instance().showRefrigeratorCoolingOn();
        RefrigeratorContext.instance().showLightOn();
        super.handleEvent(TemperatureChanged.getInstance());
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
        RefrigeratorContext.instance().changeState(CoolingModeDoorClosed.instance());
    }
    
    /**
     * Request to refrigerator context to handle cooling off event
     */
    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorOpen.instance());
    }
   
    /**
     * Request to RefirgeratorState to handle temperature changed event. 
     * 
     */
    @Override
    public void handleEvent(TemperatureChanged event) {
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            if(Temperature.getInstance().getRate()>1){
                Temperature.getInstance().decrementTemperature(3);
            }else{
                Temperature.getInstance().decrementTemperature(2);
            }
        }else{
            Temperature.getInstance().decrementTemperature(3);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}
