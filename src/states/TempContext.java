package states;

/**
 * This class is introduced by Isse to work with Isse's version of temperature 
 * fluctuation Simulation.
 * 
 * If Dave implements the temperature fluctuation simulation functionality,
 * this class should be discarded
 * 
 * TemperatureContex object contains/carries three values within.
 * The first value is the current inside temperature, the second value
 * is the current outside temperature, and the third value is the current goal
 * temperature.
 */
public class TempContext {
	
	private int internalTemp;
	private int externalTemp;
	private int goalTemp;

    /**
     * Construct for TemperatureContext object
     * @param internal temp
     * 					Current temperature inisde refrigerator
     * @param external temp
     * 					Current temp outside of the refrigerator
     * @param goal temp
     * 					Current desired temp entered by user. 
     */
	public TempContext(int internalTemp, int externalTemp, int goalTemp) {
		this.setInternalTemp(internalTemp);
		this.setExternalTemp(externalTemp);
		this.setGoalTemp(goalTemp);
	}
	
	/**
	 * getter for inside temperature value
     * @return
     * 		internalTemp;
     */
	public int getInternalTemp() {
		return internalTemp;
	}
	
	/**
	 * setter for inside temperature
     * @param
     * 		internalTemp;
     */
	public void setInternalTemp(int internalTemp) {
		this.internalTemp = internalTemp;
	}
	
	/**
	 * getter for outside temperature value
	 * @return
	 * 		externalTemp;
	 */
	public int getExternalTemp() {
		return externalTemp;
	}
	
	/**
	 * setter for outside temperature
     * @param
     * 		externalTemp;
     */
	public void setExternalTemp(int externalTemp) {
		this.externalTemp = externalTemp;
	}
	
	/**
	 * getter for goal temperature value
	 * @return
	 * 		goalTemp;
	 */
	public int getGoalTemp() {
		return goalTemp;
	}
	
	/**
	 * setter for current desired temperature
     * @param
     * 		goalTemp;
     */
	public void setGoalTemp(int goalTemp) {
		this.goalTemp = goalTemp;
	}

}
