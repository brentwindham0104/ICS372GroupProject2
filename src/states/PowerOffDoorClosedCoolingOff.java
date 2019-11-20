package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;

public class PowerOffDoorClosedCoolingOff extends RefrigeratorState {
    private static PowerOffDoorClosedCoolingOff instance;

    private PowerOffDoorClosedCoolingOff() {

    }

    public static PowerOffDoorClosedCoolingOff instance() {
        if (instance == null) {
            instance = new PowerOffDoorClosedCoolingOff();
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
    public void handleEvent(PowerOnEvent event) {

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {

    }
}
