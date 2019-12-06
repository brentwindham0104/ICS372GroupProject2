package buttons;

import events.PowerOffEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class OffButton extends GuiButton {
    public OffButton(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(PowerOffEvent.getInstance());

    }
}
