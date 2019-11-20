package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DoorButtonClose extends GUIToggleButton implements EventHandler<ActionEvent> {
    public DoorButtonClose(String name) {
        super(name);
        setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {

        System.out.println("Door Close");
    }
}
