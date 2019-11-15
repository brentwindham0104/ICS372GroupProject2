package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public class PowerButtonOn extends GUIToggleButton implements EventHandler<ActionEvent> {
    public PowerButtonOn(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
