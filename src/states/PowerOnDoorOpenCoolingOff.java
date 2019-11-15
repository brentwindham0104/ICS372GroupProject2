package states;

import events.CoolingOnEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;

public class PowerOnDoorOpenCoolingOff extends RefrigeratorState{
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
