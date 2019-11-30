package buttons;

import events.PowerOnEvent;
import javafx.event.ActionEvent;
import states.RefrigeratorContext;

public class OnButton extends GuiButton{
    public OnButton(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(PowerOnEvent.getInstance());

    }
}
