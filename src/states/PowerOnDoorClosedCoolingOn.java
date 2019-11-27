package states;

import events.CoolingOffEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;

public class PowerOnDoorClosedCoolingOn extends RefrigeratorState {
    private static PowerOnDoorClosedCoolingOn instance;

    private PowerOnDoorClosedCoolingOn(){

    }

    public static PowerOnDoorClosedCoolingOn instance(){
        if(instance==null){
            instance = new PowerOnDoorClosedCoolingOn();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOn();
        RefrigeratorContext.instance().showDoorClosed();
        RefrigeratorContext.instance().showRefrigeratorCoolingOn();
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
        RefrigeratorContext.instance().changeState(PowerOnDoorOpenCoolingOn.instance());

    }

    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorClosedCoolingOff.instance());

    }
}
