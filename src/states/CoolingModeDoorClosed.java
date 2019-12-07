package states;

import events.CoolingOffEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

/**
 * Represents the state of cooling with the door closed.
 *
 */
public class CoolingModeDoorClosed extends RefrigeratorState {
    private static CoolingModeDoorClosed instance;
    
    /**
     * Private for the singleton pattern
     */
    private CoolingModeDoorClosed(){

    }
    
    /**
     * For singleton
     * 
     * @return the object
     */
    public static CoolingModeDoorClosed instance(){
        if(instance==null){
            instance = new CoolingModeDoorClosed();
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
        RefrigeratorContext.instance().showRefrigeratorCoolingOn();
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
     * Request to refrigerator context to handle power off event
     */
    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorClosed.instance());

    }
    
    /**
     * Request to refrigerator context to handle door open event
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorOpen.instance());

    }
    
    /**
     * Request to refrigerator context to handle cooling off event
     */
    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());

    }
   
    /**
     * Request to Refirgeratorstate to handle temperature changed event. 
     * 
     */
    @Override
    public void handleEvent(TemperatureChanged event) {
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            if(Temperature.getInstance().getRate()>1){
                Temperature.getInstance().decrementTemperature(4);
            }else{
                Temperature.getInstance().decrementTemperature(3);
            }
        }else{
            Temperature.getInstance().decrementTemperature(2);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}

