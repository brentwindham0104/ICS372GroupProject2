package states;

import events.CoolingOffEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;

public class PowerOnDoorOpenCoolingOn extends RefrigeratorState{
    private static PowerOnDoorOpenCoolingOn instance;

    private PowerOnDoorOpenCoolingOn(){

    }

    public static PowerOnDoorOpenCoolingOn instance(){
        if(instance==null){
            instance = new PowerOnDoorOpenCoolingOn();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOn();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOn();
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
        RefrigeratorContext.instance().changeState(PowerOnDoorClosedCoolingOn.instance());
    }

    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorOpenCoolingOff.instance());
    }
}
