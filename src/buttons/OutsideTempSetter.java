/**
 * This class implements the button that sets the outside temperature.
 * @author Brentwindham
 */
package buttons;

import display.GUIDisplay;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class OutsideTempSetter extends GuiButton{
    private int temperature;

    public OutsideTempSetter(String string){
        super(string);
    }

/**
 * This method handles the event that sets the outside temperature
 * @param event The button push event for setting outside temperature.    
 */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().setOutsideTemp(GUIDisplay.instance().getExternalTemperature());
    }
}
