package buttons;

import events.DoorCloseEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class DoorCloseButton extends GuiButton {
    public DoorCloseButton(String name) {
        super(name);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DoorCloseEvent.getInstance());
    }
}
