package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;

public class PowerOffDoorClosedCoolingOff extends RefrigeratorState {
    private static PowerOffDoorClosedCoolingOff instance;

    private PowerOffDoorClosedCoolingOff(){

    }

    public static PowerOffDoorClosedCoolingOff instance(){
        if(instance==null){
            instance = new PowerOffDoorClosedCoolingOff();
        }
        return instance;
    }
	//just added a test comment, to see if I fixed merge issue.
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOff();
        RefrigeratorContext.instance().showDoorClosed();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOff();

    }

    @Override
    public void leave() {

    }

    @Override
    public void handleEvent(PowerOnEvent event) {
        RefrigeratorContext.instance().changeState(PowerOnDoorClosedCoolingOff.instance());


    }

    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(PowerOffDoorOpenCoolingOff.instance());



    }

}
