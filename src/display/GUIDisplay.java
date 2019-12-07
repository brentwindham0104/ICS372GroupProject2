/**
 * This class implements the GUI display for our Refrigerator Application.
 *
 * @author brentwindham
 */
package display;

import buttons.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.RefrigeratorContext;

import java.util.IllegalFormatConversionException;

public class GUIDisplay extends Application implements RefrigeratorDisplay {
    private static RefrigeratorDisplay display;
    private Text coolingStatus;
    private Text actualTemperature;
    private Text outSideTemp;
    private Text lightStatus;
    private Text powerStatus;
    private Text doorStatus;
    private GuiButton doorCloser;
    private GuiButton doorOpener;
    private GuiButton powerOnButton;
    private GuiButton powerOffButton;
    private GuiButton outsideTempSetter;
    private GuiButton desiredTempSetter;
    private TextField externalTemperatureInput;
    private TextField desiredTempratureInput;


    /**
     * This is the singleton implementation
     * @return Returns the GUIdisplay
     */
    public static RefrigeratorDisplay instance() {
        return display;
    }

    /**
     * This is the method that starts the GUI display
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        RefrigeratorContext refrigeratorContext = RefrigeratorContext.instance();
        refrigeratorContext.setDisplay(this);
        display = this;
        coolingStatus = new Text("Cooling Off");
        actualTemperature = new Text("Fridge Temp 70");
        outSideTemp = new Text("Outside Temp 70");
        lightStatus = new Text("Light Off");
        powerStatus = new Text("Power Off");
        doorStatus = new Text("Door Opened");
        doorCloser = new DoorCloseButton("close door");
        doorOpener = new DoorOpenButton("open door");
        powerOffButton = new OffButton("off");
        powerOnButton = new OnButton("on");
        externalTemperatureInput = new TextField("70");
        desiredTempratureInput = new TextField("30");
        outsideTempSetter = new OutsideTempSetter("Set Outside Temp");
        desiredTempSetter = new SetDesiredTempButton("Set Desired Fridge Temp");


        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.add(coolingStatus, 0, 0);
        pane.add(actualTemperature, 1, 0);
        pane.add(outSideTemp, 2, 0);
        pane.add(lightStatus, 3, 0);
        pane.add(powerStatus, 4, 0);
        pane.add(doorStatus, 5, 0);
        pane.add(doorCloser, 0, 1);
        pane.add(doorOpener, 1, 1);
        pane.add(powerOnButton, 2, 1);
        pane.add(powerOffButton, 3, 1);
        pane.add(externalTemperatureInput, 0, 2);
        pane.add(outsideTempSetter, 1, 2);
        pane.add(desiredTempratureInput, 2, 2);
        pane.add(desiredTempSetter, 3, 2);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Refrigerator Simulator");
//
        primaryStage.show();
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent window) {
                System.exit(0);
            }
        });


    }

    /**
     * Getter for desired temperature
     * @return The desired temperature
     */
    @Override
    public int getDesiredTemperature() {
        {
            try {
                Integer temperature = Integer.parseInt(desiredTempratureInput.getText());
                return temperature;
            } catch (IllegalFormatConversionException e) {
                desiredTempratureInput.setText("0");
                return 0;
            }
        }
    }

    /**
     * Getter for external temperature
     * @return returns The external temperature
     */
    @Override
    public int getExternalTemperature() {
        {
            try {
                Integer temperature = Integer.parseInt(externalTemperatureInput.getText());
                return temperature;
            } catch (IllegalFormatConversionException e) {
                desiredTempratureInput.setText("0");
                return 0;
            }
        }
    }

    /**
     * This shows the new internal temperature
     * @param string The new internal temperature
     */
    @Override
    public void showInternalTemperature(String string) {
        actualTemperature.setText("Fridge Temp " + string);
    }

    /**
     * This shows the new external temperature
     * @param string The new external temperature
     */
    @Override
    public void showExternalTemperature(String string) {
        outSideTemp.setText("Outside Temp " + string);
    }

    /**
     * This shows that the refrigerator is now off.
     */
    @Override
    public void showRefrigeratorOff() {
        powerStatus.setText("Power Off");

    }

    /**
     * This shows that the refrigerator is now on.
     */
    @Override
    public void showRefrigeratorOn() {
        powerStatus.setText("Power On");

    }

    /**
     * This shows that the lights are on.
     */
    @Override
    public void showLightOn() {
        lightStatus.setText("Light On");

    }

    /**
     * This shows that the lights are off.
     */
    @Override
    public void showLightOff() {
        lightStatus.setText("Light Off");

    }

    /**
     * This shows that the door is now closed.
     */
    @Override
    public void showDoorClosed() {
        doorStatus.setText("Door Closed");
    }

    /**
     * This shows that the door is now opened.
     */
    @Override
    public void showDoorOpened() {
        doorStatus.setText("Door Opened");

    }

    /**
     * This shows that the cooling is now off.
     */
    @Override
    public void showRefrigeratorCoolingOff() {
        coolingStatus.setText("Cooling Off");

    }

    /**
     * This shows that the cooling is now on.
     */
    @Override
    public void showRefrigeratorCoolingOn() {
        coolingStatus.setText("Cooling On");

    }

    /**
     * This shows the new desired temperature
     * @param value The new value for desired temperature
     */
    @Override
    public void showDesiredTemperature(String value) {
        desiredTempratureInput.setText(value);
    }
}
