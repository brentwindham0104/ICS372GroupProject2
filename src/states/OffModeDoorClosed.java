package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;

public class OffModeDoorClosed extends RefrigeratorState {
    @Override
    public void handleEvent(PowerOnEvent event) {

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {

    }


}
