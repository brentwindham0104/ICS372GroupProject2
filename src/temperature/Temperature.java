package temperature;

import events.CoolingOffEvent;
import events.CoolingOnEvent;
import events.TemperatureChanged;
import states.RefrigeratorContext;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Implements PropertyChangeListener. An Observer Object which uses
 * PropertyChangeListener to implement the Observer pattern.
 *
 */
public class Temperature implements PropertyChangeListener {
    private int outSideTemperature;
    private int fridgeTemperature;
    private int desiredTemperature;
    private int rate;
    public static Temperature instance;

    /**
     * Making it a singleton, requests the observable add it as a listener.
  	 * Lets default 
  	 * @field outSideTemperature
  	 * 			outside temp = 70
  	 * @field fridgeTemperature
  	 * 			fridge temp  = 70 
  	 * @field DesiredTemperature
  	 *			desiredtemp = 30
     */
    private Temperature(){
        outSideTemperature = 70;
        fridgeTemperature  = 70;
        desiredTemperature = 30;
        Clock.instance().addPropertyChangeListener(this);
    }
    
    /**
     * Return the instance
     * 
     * @return the object
     */
    public static Temperature getInstance(){
        if(instance==null){
            instance = new Temperature();
        }
        return instance;
    }
    
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //if temperature is greater than 100 then the increase
        //or decrease rate will be 2, and 1 otherwise.
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
    
    /**
	 * setter for outside temperature
     * @param
     * 		temperature;
     */
    public void setOutSideTemperature(int temperature){
        outSideTemperature=temperature;
    }
    
    /**
	 * setter for desired temperature
     * @param
     * 		desiredTemperature;
     */
    public void setDesiredTemperature(int temperature){
        desiredTemperature = temperature;
    }
    
    /**
	 * setter for fridge temperature
     * @param
     * 		fridgeTemperature;
     */
    public void setFridgeTemperature(int temperature){
        fridgeTemperature= temperature;
    }
    
    /**
	 * getter for outside temperature value
     * @return
     * 		outsideTemperature;
     */
    public int getOutSideTemperature() {
        return outSideTemperature;
    }
    
    /**
	 * getter for fridge temperature value
     * @return
     * 		fridgeTemperature;
     */
    public int getFridgeTemperature() {
        return fridgeTemperature;
    }
    
    /**
	 * getter for outside temperature value
     * @return
     * 		desiredTemperature;
     */
    public int getDesiredTemperature() {
        return desiredTemperature;
    }
    
    /**
     * @param
     * 		rate;
     */
    public void decrementTemperature(int rate){
        fridgeTemperature-=rate;
    }
    
    /**
     * @param
     * 		rate;
     */
    public void incrementTemperature(int rate){
        fridgeTemperature+=rate;
    }
   
    /**
	 * getter for rate of temperature change
     * @return
     * 		rate;
     */
    public int getRate(){
        return rate;
    }
}
