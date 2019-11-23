package buttons;

import events.DoorCloseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import states.RefrigeratorContext;
/**
 * Creating close door button and adding button functionality
 */
public class DoorButtonClose extends GUIButton implements EventHandler<ActionEvent> {
	/**
     * Creates the Door close button with the proper label
     * 
     * @param name
     *            the label
     */
	public DoorButtonClose(String name) {
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
