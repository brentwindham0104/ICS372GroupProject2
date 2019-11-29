package buttons;

import events.ExternalTempChangeEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import states.RefrigeratorContext;

/**
 * Creating set external temp button and adding button functionality
 */
public class SetExternalTempButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * The button for setting external temp with proper label
     * 
     * @param name
     *            the label
     */
	public SetExternalTempButton(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to set current external temp
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(ExternalTempChangeEvent.instance());
    }
}
