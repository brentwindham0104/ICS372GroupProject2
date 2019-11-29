package buttons;

import events.DoorCloseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import states.RefrigeratorContext;
/**
 * Creating door close button and adding button functionality
 */
public class DoorCloseButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * Creates the Door close button with the proper label
     * 
     * @param name
     *            the label
     */
	public DoorCloseButton(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to handle event accordingly
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(DoorCloseEvent.instance());
    }
}
