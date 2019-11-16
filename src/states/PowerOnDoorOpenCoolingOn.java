package states;

import events.CoolingOffEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;

public class PowerOnDoorOpenCoolingOn extends RefrigeratorState{
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
