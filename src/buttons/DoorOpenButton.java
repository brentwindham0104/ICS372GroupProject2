/**
 * This class implements the button that opens the door.
 * @author brentwindham
 */
package buttons;

import events.DoorOpenEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class DoorOpenButton extends GuiButton{
    public DoorOpenButton(String name) {
        super(name);
        setOnAction(this);
    }

/**
 * This method handles the DoorOpenEvent
 * @param event The button push event for door open.
 */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DoorOpenEvent.getInstance());
    }
}
