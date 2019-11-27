package states;

import events.CoolingOnEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;

public class PowerOnDoorClosedCoolingOff extends RefrigeratorState{

    private static PowerOnDoorClosedCoolingOff instance;

    private PowerOnDoorClosedCoolingOff(){

    }

    public static PowerOnDoorClosedCoolingOff instance(){
        if(instance==null){
            instance = new PowerOnDoorClosedCoolingOff();
        }
        return instance;
    }
    @Override
    public void enter() {
            RefrigeratorContext.instance().showRefrigeratorOn();
            RefrigeratorContext.instance().showDoorClosed();
            RefrigeratorContext.instance().showRefrigeratorCoolingOff();
            RefrigeratorContext.instance().showLightOff();

    }

    @Override
    public void leave() {

    }

    @Override
    public void handleEvent(PowerOffEvent event) {
        RefrigeratorContext.instance().changeState(PowerOffDoorClosedCoolingOff.instance());

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorOpenCoolingOff.instance());

    }

    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorClosedCoolingOn.instance());

    }

}
