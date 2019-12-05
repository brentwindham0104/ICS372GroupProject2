package states;

import events.CoolingOffEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;

public class CoolingModeDoorClosed extends RefrigeratorState {
    @Override
    public void handleEvent(PowerOffEvent event) {

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {

    }

    @Override
    public void handleEvent(CoolingOffEvent event) {

    }
}
