/**
 * This class is the driver for the whole project.
 * @author brentwindham
 */
package start;

import display.GUIDisplay;
import display.RefrigeratorDisplay;
import javafx.application.Application;
import states.RefrigeratorContext;
import temperature.Clock;

public class Main {
    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUIDisplay.class, null);
            }
        }.start();
        try {
            while (GUIDisplay.instance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
        }
        RefrigeratorDisplay display = GUIDisplay.instance();
        RefrigeratorContext.instance().setDisplay(display);
    }
}
