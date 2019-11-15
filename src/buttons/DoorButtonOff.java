package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DoorButtonOff extends Button implements EventHandler<ActionEvent> {
    public DoorButtonOff(String name) {
        super(name);
    }

    @Override
    public void handle(ActionEvent event) {
    }
}
