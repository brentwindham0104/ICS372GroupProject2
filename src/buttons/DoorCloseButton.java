/**
 * This class implements the button that closes the door.
 *
 * @author brentwindham
 */
package buttons;

import events.DoorCloseEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class DoorCloseButton extends GuiButton {
    public DoorCloseButton(String name) {
        super(name);
    }

    /**
     * This method  handles the DoorCloseEvent
     * @param event This is the button push event for DoorClose
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DoorCloseEvent.getInstance());
    }
}
