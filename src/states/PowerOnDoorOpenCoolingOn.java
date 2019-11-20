package states;

import events.CoolingOffEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;

public class PowerOnDoorOpenCoolingOn extends RefrigeratorState{
    private static PowerOnDoorOpenCoolingOn instance;

    private PowerOnDoorOpenCoolingOn() {

    }

    public static PowerOnDoorOpenCoolingOn instance() {
        if (instance == null) {
            instance = new PowerOnDoorOpenCoolingOn();
        }

        return instance;
    }

    @Override
    public void enter() {

    }

    @Override
    public void leave() {

    }

    @Override
    public void handleEvent(PowerOffEvent event) {
    }

    @Override
    public void handleEvent(DoorCloseEvent event) {
    }

    @Override
    public void handleEvent(CoolingOffEvent event) {
    }
}
