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

    /**
     * This will be triggered by the observable class(Clock) and will
     * send cooling on or off events when the fridge temperature approaches
     * the desired temperature
     * @param evt
     *           clock tick event sent from observable class Clock
     */
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //if temperature is greater than 100 then the increase
        //or decrease rate will be 2, and 1 otherwise.
        rate = Math.abs(outSideTemperature) > 100 ?  2 : 1;
        //this below statements will attempt to approach the
        //fridge temperature to outside temperature
        if(fridgeTemperature<outSideTemperature){
            fridgeTemperature+=rate;
        }else if(fridgeTemperature>outSideTemperature){
            fridgeTemperature-=rate;
        }
         //if fridge temperature is less than the desired temperature,
        //cooling off event will be sent, and cooling on event otherwise.
        
        if (rate == 1 ) {
        	if(fridgeTemperature<=desiredTemperature-2){
                RefrigeratorContext.instance().handleEvent(CoolingOffEvent.getInstance());
            }else if(fridgeTemperature>=desiredTemperature+4){
                RefrigeratorContext.instance().handleEvent(CoolingOnEvent.getInstance());
            }
        } else {
        	if(fridgeTemperature<=desiredTemperature-1){
                RefrigeratorContext.instance().handleEvent(CoolingOffEvent.getInstance());
            }else if(fridgeTemperature>=desiredTemperature+5){
                RefrigeratorContext.instance().handleEvent(CoolingOnEvent.getInstance());
            }
            
        }
        
            RefrigeratorContext.instance().handleEvent(TemperatureChanged.getInstance());
    }
    
    /**
	 * setter for outside temperature
     * @param
     * 		temperature the temperature to change the outside temperature to
     *
     */
    public void setOutSideTemperature(int temperature){
        outSideTemperature=temperature;
    }
    
    /**
	 * setter for desired temperature
     * @param
     * 		temperature the desired temperature to be set to
     */
    public void setDesiredTemperature(int temperature){
        desiredTemperature = temperature;
    }
    
    /**
	 * setter for fridge temperature
     * @param
     * 		temperature the fridge temperature to set to
     */
    public void setFridgeTemperature(int temperature){
        fridgeTemperature= temperature;
    }
    
    /**
	 * getter for outside temperature value
     * @return
     * 		  the outside temperature value;
     */
    public int getOutSideTemperature() {
        return outSideTemperature;
    }
    
    /**
	 * getter for fridge temperature value
     * @return
     * 		the fridge temperature
     */
    public int getFridgeTemperature() {
        return fridgeTemperature;
    }
    
    /**
	 * getter for outside temperature value
     * @return
     * 		the desired temperature
     */
    public int getDesiredTemperature() {
        return desiredTemperature;
    }
    
    /**
     * @param
     * 		rate the rate at which to decrement the internal temperature
     */
    public void decrementTemperature(int rate){
        fridgeTemperature-=rate;
    }
    
    /**
     * @param
     * 		rate the rate at which to increment the internal temperature
     */
    public void incrementTemperature(int rate){
        fridgeTemperature+=rate;
    }
   
    /**
	 * getter for rate of temperature change
     * @return
     * 		rate of temperature changes
     */
    public int getRate(){
        return rate;
    }
}
