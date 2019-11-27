package states;

import events.DoorCloseEvent;

public class PowerOffDoorOpenCoolingOff extends RefrigeratorState {
    private static PowerOffDoorOpenCoolingOff instance;

    private PowerOffDoorOpenCoolingOff(){

    }

    public static PowerOffDoorOpenCoolingOff instance(){
        if(instance==null){
            instance = new PowerOffDoorOpenCoolingOff();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOff();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOff();

    }

    @Override
    public void leave() {


    }

    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(PowerOffDoorClosedCoolingOff.instance());

    }
}
