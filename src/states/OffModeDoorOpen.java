package states;

import events.DoorCloseEvent;
import events.TemperatureChanged;
import temperature.Temperature;

public class OffModeDoorOpen extends RefrigeratorState {
    private static OffModeDoorOpen instance;

    private OffModeDoorOpen(){

    }

    public static OffModeDoorOpen instance(){
        if(instance==null){
            instance = new OffModeDoorOpen();
        }
        return instance;
    }
    @Override
    public void enter() {
        RefrigeratorContext.instance().showRefrigeratorOff();
        RefrigeratorContext.instance().showDoorOpened();
        RefrigeratorContext.instance().showRefrigeratorCoolingOff();
        RefrigeratorContext.instance().showLightOff();
        Temperature.getInstance().setOutSideTemperature(70);
        Temperature.getInstance().setFridgeTemperature(70);
        Temperature.getInstance().setDesiredTemperature(30);
        RefrigeratorContext.instance().handleEvent(TemperatureChanged.getInstance());

    }

    @Override
    public void leave() {


    }

    @Override
    public void handleEvent(DoorCloseEvent event) {
        RefrigeratorContext.instance().changeState(OffModeDoorClosed.instance());
    }

    @Override
    public void handleEvent(TemperatureChanged event) {
        if (Temperature.getInstance().getFridgeTemperature() != Temperature.getInstance().getOutSideTemperature()) {
            if (Temperature.getInstance().getOutSideTemperature() >
                    Temperature.getInstance().getFridgeTemperature()) {
                if (Temperature.getInstance().getRate() > 1) {
                    Temperature.getInstance().incrementTemperature(1);
                } else {
                    Temperature.getInstance().incrementTemperature(1);
                }
            } else {
                Temperature.getInstance().decrementTemperature(1);
            }
            super.handleEvent(TemperatureChanged.getInstance());
        }
    }

}
