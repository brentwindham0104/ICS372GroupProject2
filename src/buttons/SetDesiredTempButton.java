/**
 * This class implements the button that sets the desired temperature for the Refrigerator.
 * @author brentwindham
 */
package buttons;

import display.GUIDisplay;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class SetDesiredTempButton extends GuiButton {
    public SetDesiredTempButton(String string) {
        super(string);
    }

/**
 * This method handles the setting desired temperature event.
 * @param event The button push event for setting the desired temperature.
 */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().setDesiredTemp(GUIDisplay.instance().getDesiredTemperature());
    }
}
