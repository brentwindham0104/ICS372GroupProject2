package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;
import events.TemperatureChanged;
import temperature.Temperature;

/**
 * Represents the state Refrigerator off with the door closed.
 */
public class OffModeDoorClosed extends RefrigeratorState {
    private static OffModeDoorClosed instance;

    /**
     * Private for the singleton pattern
     */
    private OffModeDoorClosed() {

    }

    /**
     * For singleton
     *
     * @return the object
     */
    public static OffModeDoorClosed instance() {
        if (instance == null) {
            instance = new OffModeDoorClosed();
        }
        return instance;
    }

    /**
     * Updates indicators on GUI display to refelect the current state. The method
     * enter() is tasked with completing initialization requirements.
     */
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOff();
        RefrigeratorContext.instance().showDoorClosed();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOff();
        String desiredTemp = String.valueOf(Temperature.getInstance().getDesiredTemperature());
        RefrigeratorContext.instance().showDesiredTemperature(desiredTemp);
        RefrigeratorContext.instance().handleEvent(TemperatureChanged.getInstance());

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
     * @param event the reference for the power on event.
     */
    @Override
    public void handleEvent(PowerOnEvent event) {
        leave();
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());
    }

    /**
     * Request to refrigerator context to handle corresponding state change
     *
     * @param event the reference for the door open event.
     */
    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorOpen.instance());

    }
}
