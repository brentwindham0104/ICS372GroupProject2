package states;

import events.CoolingOnEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;

public class PowerOnDoorClosedCoolingOff extends RefrigeratorState {
    private static PowerOnDoorClosedCoolingOff instance;

    private PowerOnDoorClosedCoolingOff() {

    }

    public static PowerOnDoorClosedCoolingOff instance() {
        if (instance == null) {
            instance = new PowerOnDoorClosedCoolingOff();
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
    public void handleEvent(DoorOpenEvent event) {

    }

    @Override
    public void handleEvent(CoolingOnEvent event) {

    }

}
