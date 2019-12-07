/**
 * This class implements the button that turns on the Refrigerator.
 *
 * @author brentwindham
 */
package buttons;

import events.PowerOnEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class OnButton extends GuiButton {
    public OnButton(String name) {
        super(name);
        setOnAction(this);
    }

    /**
     * This method handles the PowerOnEvent.
     * @param event The button push event for PowerOn
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(PowerOnEvent.getInstance());

    }
}
