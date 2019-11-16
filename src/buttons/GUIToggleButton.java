package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;

public abstract class GUIToggleButton extends ToggleButton implements EventHandler<ActionEvent> {
    public GUIToggleButton(String name) {
        super(name);
        setOnAction(this);
    }
}
