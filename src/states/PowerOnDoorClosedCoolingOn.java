package states;

import events.CoolingOffEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;

public class PowerOnDoorClosedCoolingOn extends RefrigeratorState {
    private static PowerOnDoorClosedCoolingOn instance;

    private PowerOnDoorClosedCoolingOn() {

    }

    public static PowerOnDoorClosedCoolingOn instance() {
        if (instance == null) {
            instance = new PowerOnDoorClosedCoolingOn();
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
    public void handleEvent(CoolingOffEvent event) {

    }
}
