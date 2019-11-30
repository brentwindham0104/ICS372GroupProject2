package buttons;

import display.GUIDisplay;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class OutsideTempSetter extends GuiButton{
    private int temperature;

    public OutsideTempSetter(String string){
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().setOutsideTemp(GUIDisplay.instance().getExternalTemperature());
    }
}
