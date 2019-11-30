package display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface RefrigeratorDisplay {
  
    /**
     * Indicate that the light is on
     */
    public void showLightOn();

    /**
     * Indicate that the light is off
     */
    public void showLightOff();

    /**
     * Indicate that the door is now closed
     */
    public void showDoorClosed();

    /**
     * Indicate that the door is now open
     */
    public void showDoorOpened();
    
    /**
     * indicate refrigerator is off
     */
    public void showRefrigeratorOff();
   
    /**
     * indicate refrigerator is on
     */
    public void showRefrigeratorOn();

    /**
     * indicate that refrigerator is not cooling
     */
    public void showRefrigeratorCoolingOff();
    
    /**
     * indicate that refrigerator is  cooling
     */
    public void showRefrigeratorCoolingOn();
    
    /**
     * indicate inside temperature
     */
    public void showInternalTemperature(String string);
   
    /**
     * indicate outside temperature
     */
    public void showExternalTemperature(String string);


    public int getDesiredTemperature();

    public int getExternalTemperature();
}