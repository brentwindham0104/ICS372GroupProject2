package states;

import events.CoolingOnEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;

public class PowerOnDoorOpenCoolingOff extends RefrigeratorState{
    private static PowerOnDoorOpenCoolingOff instance;

    private PowerOnDoorOpenCoolingOff() {

    }

    public static PowerOnDoorOpenCoolingOff instance() {
        if (instance == null) {
            instance = new PowerOnDoorOpenCoolingOff();
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
    public void handleEvent(CoolingOnEvent event) {
    }
}
