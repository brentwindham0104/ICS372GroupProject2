package states;

import events.DoorCloseEvent;
import events.TemperatureChanged;
import temperature.Temperature;

/**
 * Represents the state Refrigerator off with the door closed.
 *
 */
public class OffModeDoorOpen extends RefrigeratorState {
    private static OffModeDoorOpen instance;
    
    /**
     * Private for the singleton pattern
     */
    private OffModeDoorOpen(){

    }
    
    /**
     * For singleton
     * 
     * @return the object
     */
    public static OffModeDoorOpen instance(){
        if(instance==null){
            instance = new OffModeDoorOpen();
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
        Temperature.getInstance().setOutSideTemperature(70);
        Temperature.getInstance().setFridgeTemperature(70);
        Temperature.getInstance().setDesiredTemperature(30);
        RefrigeratorContext.instance().showRefrigeratorOff();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOff();
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
     * Request to refrigerator context to handle door close event
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorClosed.instance());
    }
    
    /**
     * Request to RefirgeratorState to handle temperature changed event. 
     * 
     */
    @Override
    public void handleEvent(TemperatureChanged event) {
        if (Temperature.getInstance().getFridgeTemperature() != Temperature.getInstance().getOutSideTemperature()) {
            if (Temperature.getInstance().getOutSideTemperature() >
                    Temperature.getInstance().getFridgeTemperature()) {
                if (Temperature.getInstance().getRate() > 1) {
                    Temperature.getInstance().incrementTemperature(1);
                } else {
                    Temperature.getInstance().incrementTemperature(1);
                }
            } else {
                Temperature.getInstance().decrementTemperature(1);
            }
            super.handleEvent(TemperatureChanged.getInstance());
        }
    }
}
