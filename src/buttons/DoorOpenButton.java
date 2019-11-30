package buttons;

import events.DoorOpenEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class DoorOpenButton extends GuiButton{
    public DoorOpenButton(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DoorOpenEvent.getInstance());
    }
}
