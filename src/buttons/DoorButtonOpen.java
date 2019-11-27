package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DoorButtonOpen extends GUIToggleButton implements EventHandler<ActionEvent> {
    public DoorButtonOpen(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
    }
}
