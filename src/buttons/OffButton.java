package buttons;

import events.PowerOffEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import states.RefrigeratorContext;
/**
 * Creating power off button and adding button functionality
 */
public class OffButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * The button for turning the power off with proper label
     * 
     * @param name
     *            the label
     */
	public OffButton(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to handle event accordingly
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(PowerOffEvent.instance());
    }
}
