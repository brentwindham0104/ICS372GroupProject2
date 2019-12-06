package states;

import events.CoolingOffEvent;
import events.DoorCloseEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

public class CoolingModeDoorOpen extends RefrigeratorState{
    private static CoolingModeDoorOpen instance;

    private CoolingModeDoorOpen(){

    }

    public static CoolingModeDoorOpen instance(){
        if(instance==null){
            instance = new CoolingModeDoorOpen();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOn();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOn();
        RefrigeratorContext.instance().showLightOn();
        super.handleEvent(TemperatureChanged.getInstance());
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
        RefrigeratorContext.instance().changeState(CoolingModeDoorClosed.instance());
    }

    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorOpen.instance());
    }

    @Override
    public void handleEvent(TemperatureChanged event) {
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            if(Temperature.getInstance().getRate()>1){
                Temperature.getInstance().decrementTemperature(3);
            }else{
                Temperature.getInstance().decrementTemperature(2);
            }
        }else{
            Temperature.getInstance().decrementTemperature(3);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}
