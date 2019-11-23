package buttons;

import events.DoorOpenEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import states.RefrigeratorContext;
/**
 * Creating open door button and adding button functionality
 */
public class DoorButtonOpen extends GUIButton implements EventHandler<ActionEvent> {
	 /**
     * Create the door open button with the proper label
     * 
     * @param name
     *            the label
     */
	public DoorButtonOpen(String name) {
        super(name);
    }
	/**
	 * Request to RefrigeratorContext to handle event accordingly
	 */
    @Override
    public void handle(ActionEvent event) {
    	 RefrigeratorContext.instance().handleEvent(DoorOpenEvent.instance());
    }
}
