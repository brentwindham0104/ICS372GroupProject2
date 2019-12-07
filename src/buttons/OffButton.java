/**
 * This class implements the button that turns off the Refrigerator.
 *
 * @author brentwindham
 */
package buttons;

import events.PowerOffEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class OffButton extends GuiButton {
    public OffButton(String name) {
        super(name);
        setOnAction(this);
    }

    /**
     * This method handles the PowerOffEvent.
     * @param event The button push event for PowerOff
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(PowerOffEvent.getInstance());

    }
}
