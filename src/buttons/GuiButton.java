package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class GuiButton extends Button implements EventHandler<ActionEvent> {
    public GuiButton(String name) {
        super(name);
        setOnAction(this);
    }
}
