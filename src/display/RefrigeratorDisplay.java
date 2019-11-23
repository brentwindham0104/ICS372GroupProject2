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
     * Indicate refrigerator is off
     */
    public void showRefrigeratorOff();
   
    /**
     * Indicate refrigerator is on
     */
    public void showRefrigeratorOn();

    /**
     * Indicate that refrigerator is not cooling
     */
    public void showRefrigeratorCoolingOff();
    
    /**
     * Indicate that refrigerator is  cooling
     */
    public void showRefrigeratorCoolingOn();
    
    /**
     * Indicate inside temperature
     *  * @param temp
     *            current inside temp
     */
    public void showInternalTemperature(int temp);
   
    /**
     * Indicate external temperature
     *  * @param temp
     *            current external temp
     */
    public void showExternalTemperature(int temp);
}