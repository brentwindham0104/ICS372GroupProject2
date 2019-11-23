package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;

public class PowerOffDoorClosedCoolingOff extends RefrigeratorState {
    @Override
    public void handleEvent(PowerOnEvent event) {

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {

    }

}
