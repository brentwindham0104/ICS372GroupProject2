package buttons;

import display.GUIDisplay;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class SetDesiredTempButton extends GuiButton {
    public SetDesiredTempButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().setDesiredTemp(GUIDisplay.instance().getDesiredTemperature());
    }
}
