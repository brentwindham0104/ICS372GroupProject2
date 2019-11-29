package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
/**
 * The abstract GUI JButton object. Helps to get rid of conditionals
 *
 */
public abstract class GUIButton extends ToggleButton implements EventHandler<ActionEvent> {
	/**
     * Create the button with the proper text. Makes the button a listener to
     * clicks on itself.
     * 
     * @param name
     *            the text
     */
	public GUIButton(String name) {
        super(name);
        setOnAction(this);
    }
}
