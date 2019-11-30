package states;

import events.DoorOpenEvent;
import events.PowerOnEvent;
import events.TemperatureChanged;
import temperature.Temperature;

public class OffModeDoorClosed extends RefrigeratorState {
    private static OffModeDoorClosed instance;

    private OffModeDoorClosed(){

    }

    public static OffModeDoorClosed instance(){
        if(instance==null){
            instance = new OffModeDoorClosed();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOff();
        RefrigeratorContext.instance().showDoorClosed();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOff();
        Temperature.getInstance().setOutSideTemperature(70);
        Temperature.getInstance().setFridgeTemperature(70);
        RefrigeratorContext.instance().handleEvent(TemperatureChanged.getInstance());

    }

    @Override
    public void leave() {

    }

    @Override
    public void handleEvent(PowerOnEvent event) {
        leave();
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());


    }

    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorOpen.instance());



    }

}
