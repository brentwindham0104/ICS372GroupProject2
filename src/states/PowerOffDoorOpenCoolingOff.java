package states;

import events.DoorCloseEvent;

public class PowerOffDoorOpenCoolingOff extends RefrigeratorState {
    private static PowerOffDoorOpenCoolingOff instance;

    private PowerOffDoorOpenCoolingOff() {

    }

    public static PowerOffDoorOpenCoolingOff instance() {
        if (instance == null) {
            instance = new PowerOffDoorOpenCoolingOff();
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
    public void handleEvent(DoorCloseEvent event) {

    }

}
