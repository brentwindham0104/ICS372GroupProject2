package states;

import events.CoolingOnEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;

public class IdleModeDoorClosed extends RefrigeratorState{

    private static IdleModeDoorClosed instance;

    private IdleModeDoorClosed(){

    }

    public static IdleModeDoorClosed instance(){
        if(instance==null){
            instance = new IdleModeDoorClosed();
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
        RefrigeratorContext.instance().changeState(OffModeDoorClosed.instance());

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorOpen.instance());

    }

    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorClosed.instance());

    }


}
