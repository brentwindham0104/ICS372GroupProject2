package states;

import events.CoolingOffEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

/**
 * Represents the state of cooling with the door opened.
 * @author Brent
 */
public class CoolingModeDoorOpen extends RefrigeratorState {
    private static CoolingModeDoorOpen instance;

    /**
     * Private for the singleton pattern
     */
    private CoolingModeDoorOpen() {

    }

    /**
     * For singleton
     *
     * @return the object
     */
    public static CoolingModeDoorOpen instance() {
        if (instance == null) {
            instance = new CoolingModeDoorOpen();
        }
        return instance;
    }

    /**
     * Updates indicators on GUI display to refelect the current state. The method
     * enter() is tasked with completing initialization requirements.
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
     * Updates indicators on GUI display to refelect the current state. The method
     * leave() is tasked with completing exiting clean up.
     */
    @Override
    public void leave() {

    }

    /**
     * Request to refrigerator context to handle corresponding state change
     *
     * @param event the reference for the power off event.
     */
    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorOpen.instance());
    }

    /**
     * Request to refrigerator context to handle corresponding state change
     *
     * @param event the reference for the door close event.
     */
    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorClosed.instance());
    }

    /**
     * Request to refrigerator context to handle corresponding state change
     *
     * @param event the reference for the Cooling  off event.
     */
    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorOpen.instance());
    }

    /**
     * Request to RefirgeratorState to handle temperature changed event.
     *
     * @param event the reference for the Temperature event.
     */
    @Override
    public void handleEvent(TemperatureChanged event) {
        //if temperature is increasing,and outside temperature
        //is hotter, then opening the door will work against cooling
        //and will help cooling if outside is colder.
        //the values are 3, and 2 are chosen so that incrementing
        //and decrementing do not cancel each other.
        if (Temperature.getInstance().getOutSideTemperature() >
                Temperature.getInstance().getFridgeTemperature()) {
            if (Temperature.getInstance().getRate() > 1) {
                Temperature.getInstance().decrementTemperature(3);
            } else {
                Temperature.getInstance().decrementTemperature(2);
            }
        } else {
            Temperature.getInstance().decrementTemperature(3);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}
