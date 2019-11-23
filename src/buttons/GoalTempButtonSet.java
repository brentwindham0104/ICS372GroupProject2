package buttons;

import events.GoalTempSetEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import states.RefrigeratorContext;

/**
 * Creating set goal temp button and adding button functionality
 */
public class GoalTempButtonSet extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * The button for setting goal temp with proper label
     * 
     * @param name
     *            the label
     */
	public GoalTempButtonSet(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to set goal temperature
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(GoalTempSetEvent.instance());
    }
}
