package states;

import events.CoolingOffEvent;
import events.DoorOpenEvent;
import events.PowerOffEvent;
import events.TemperatureChanged;
import temperature.Temperature;

public class CoolingModeDoorClosed extends RefrigeratorState {
    private static CoolingModeDoorClosed instance;

    private CoolingModeDoorClosed(){

    }

    public static CoolingModeDoorClosed instance(){
        if(instance==null){
            instance = new CoolingModeDoorClosed();
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
        RefrigeratorContext.instance().changeState(OffModeDoorClosed.instance());

    }

    @Override
    public void handleEvent(DoorOpenEvent event) {
        RefrigeratorContext.instance().changeState(CoolingModeDoorOpen.instance());

    }

    @Override
    public void handleEvent(CoolingOffEvent event) {
        RefrigeratorContext.instance().changeState(IdleModeDoorClosed.instance());

    }

    @Override
    public void handleEvent(TemperatureChanged event) {
        if(Temperature.getInstance().getOutSideTemperature()>
                Temperature.getInstance().getFridgeTemperature()){
            if(Temperature.getInstance().getRate()>1){
                Temperature.getInstance().decrementTemperature(4);
            }else{
                Temperature.getInstance().decrementTemperature(3);
            }
        }else{
            Temperature.getInstance().decrementTemperature(2);
        }
        super.handleEvent(TemperatureChanged.getInstance());
    }
}

