/**
 * This is an abstract class that implements the button.
 */
package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class GuiButton extends Button implements EventHandler<ActionEvent> {
	
	/**
	 * Constructor for button.
	 * @param name The words displayed on the button.
	 */
    public GuiButton(String name) {
        super(name);
        setOnAction(this);
    }
}
