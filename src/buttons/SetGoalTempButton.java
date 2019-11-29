package buttons;

import events.GoalTempChangeEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import states.RefrigeratorContext;

/**
 * Creating set goal temp button and adding button functionality
 */
public class SetGoalTempButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * The button for setting goal temp with proper label
     * 
     * @param name
     *            the label
     */
	public SetGoalTempButton(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to set goal temperature
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(GoalTempChangeEvent.instance());
    }
}
