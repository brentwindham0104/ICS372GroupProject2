package temperature;

import events.CoolingOffEvent;
import events.CoolingOnEvent;
import events.TemperatureChanged;
import states.RefrigeratorContext;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Temperature implements PropertyChangeListener {
    private int outSideTemperature;
    private int fridgeTemperature;
    private int desiredTemperature;
    private int rate;
    public static Temperature instance;


    private Temperature(){
        outSideTemperature =70;
        fridgeTemperature = 70;
        desiredTemperature=30;
        Clock.instance().addPropertyChangeListener(this);
    }

    public static Temperature getInstance(){
        if(instance==null){
            instance = new Temperature();
        }
        return instance;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        rate = Math.abs(outSideTemperature) > 100 ?  2 : 1;
        if(fridgeTemperature<outSideTemperature){
            fridgeTemperature+=rate;
        }else if(fridgeTemperature>outSideTemperature){
            fridgeTemperature-=rate;
        }

        if(fridgeTemperature<=desiredTemperature-3){
            RefrigeratorContext.instance().handleEvent(CoolingOffEvent.getInstance());
        }else if(fridgeTemperature>=desiredTemperature+3){
            RefrigeratorContext.instance().handleEvent(CoolingOnEvent.getInstance());
        }
            RefrigeratorContext.instance().handleEvent(TemperatureChanged.getInstance());
    }

    public void setOutSideTemperature(int temperature){
        outSideTemperature=temperature;
    }

    public void setDesiredTemperature(int temperature){
        desiredTemperature = temperature;
    }

    public void setFridgeTemperature(int temperature){
        fridgeTemperature= temperature;
    }

    public int getOutSideTemperature() {
        return outSideTemperature;
    }

    public int getFridgeTemperature() {
        return fridgeTemperature;
    }

    public int getDesiredTemperature() {
        return desiredTemperature;
    }

    public void decrementTemperature(int rate){
        fridgeTemperature-=rate;
    }

    public void incrementTemperature(int rate){
        fridgeTemperature+=rate;
    }

    public int getRate(){
        return rate;
    }
}
