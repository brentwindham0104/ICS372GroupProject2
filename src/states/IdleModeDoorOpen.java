package states;

import events.CoolingOnEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

public class IdleModeDoorOpen extends RefrigeratorState{
    private static IdleModeDoorOpen instance;

    private IdleModeDoorOpen(){

    }

    public static IdleModeDoorOpen instance(){
        if(instance==null){
            instance = new IdleModeDoorOpen();
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
        RefrigeratorContext.instance().changeState(OffModeDoorOpen.instance());
    }

    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());
    }

    @Override
    public void handleEvent(CoolingOnEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorOpen.instance());
    }

    @Override
    public void handleEvent(TemperatureChanged event) {
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            Temperature.getInstance().incrementTemperature(1);
        }else{
            Temperature.getInstance().decrementTemperature(1);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}
