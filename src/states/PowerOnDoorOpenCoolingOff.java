package states;

import events.CoolingOnEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;

public class PowerOnDoorOpenCoolingOff extends RefrigeratorState{
    private static PowerOnDoorOpenCoolingOff instance;

    private PowerOnDoorOpenCoolingOff(){

    }

    public static PowerOnDoorOpenCoolingOff instance(){
        if(instance==null){
            instance = new PowerOnDoorOpenCoolingOff();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOn();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOn();

    }

    @Override
    public void leave() {

    }

    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(PowerOffDoorOpenCoolingOff.instance());
    }

    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorClosedCoolingOff.instance());
    }

    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorOpenCoolingOn.instance());
    }
}
