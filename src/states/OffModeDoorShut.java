package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;

public class OffModeDoorShut extends RefrigeratorState {
    @Override
    public void handleEvent(PowerOnEvent event) {

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {

    }


}
