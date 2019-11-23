package buttons;

import events.PowerOnEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import states.RefrigeratorContext;
/**
 * Creating power on button and adding button functionality
 */
public class PowerButtonOn extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * The button for turning the power on with proper label
     * 
     * @param name
     *            the label
     */
	public PowerButtonOn(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to handle event accordingly
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(PowerOnEvent.instance());
    }
}
