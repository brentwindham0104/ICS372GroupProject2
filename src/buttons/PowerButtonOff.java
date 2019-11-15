package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public class PowerButtonOff extends GUIToggleButton implements EventHandler<ActionEvent> {
    public PowerButtonOff(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
