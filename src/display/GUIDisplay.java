package display;

import buttons.DoorButtonClose;
import buttons.DoorButtonOpen;
import buttons.PowerButtonOff;
import buttons.PowerButtonOn;
import buttons.ExternalTempButtonSet;
import buttons.GoalTempButtonSet;
import buttons.GUIButton;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.RefrigeratorContext;

/**
 * GUI to implement the RefrigeratorDisplay
 *
 */
public class GUIDisplay extends Application implements RefrigeratorDisplay {
    private GUIButton powerOnSwitcher;
    private GUIButton powerOffSwitcher;
    private GUIButton doorCloser;
    private GUIButton doorOpener;
    private GUIButton goalTemperatureInputter;
    private GUIButton externalTemperatureInputter;
    
    private Text powerStatus = new Text("Fridge Off");
    private Text doorStatus = new Text("Door Closed");
    private Text lightStatus = new Text("Light Off");
    private Text coolingStatus = new Text("Not Cooling");
    private Text internalStatus= new Text("       ");
    private Text externalStatus= new Text("       ");
    
    private TextField goalTemperatureInput;
    private TextField externalTemperatureInput;
    
    private static RefrigeratorDisplay display;
    private RefrigeratorContext refrigeratorContext;
    
    public void start(Stage primaryStage) throws Exception {
        
    	refrigeratorContext = RefrigeratorContext.instance();
        refrigeratorContext.setDisplay(this);
        display = this;    
        
        powerOnSwitcher = new PowerButtonOn("On");
        powerOffSwitcher = new PowerButtonOn("Off");
        doorOpener = new DoorButtonOpen("open door");  
        doorCloser = new DoorButtonClose("close door"); 
        externalTemperatureInputter = new ExternalTempButtonSet("Set Outside Temp");
        goalTemperatureInputter = new GoalTempButtonSet("Set Desired Fridge Temp");
        
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        
        pane.add(coolingStatus, 0, 0);
        pane.add(internalStatus, 2, 0);
        pane.add(externalStatus, 4, 0);
        pane.add(lightStatus, 6, 0);
        pane.add(doorStatus, 8, 0);
        pane.add(powerStatus, 10, 0);
        
        
        pane.add(powerOnSwitcher, 12, 0);
        pane.add(powerOffSwitcher, 0, 1);
        pane.add(doorOpener, 2, 1);
        pane.add(doorCloser, 4, 1);
        pane.add(goalTemperatureInput, 6, 1);
        pane.add(externalStatus, 8, 1);
        pane.add(externalTemperatureInput, 10, 1);
        pane.add(internalStatus, 12, 1);   
        
        showDoorClosed();
        showLightOff();
        showRefrigeratorOff();
        showInternalTemperature();
        showExternalTemperature();
        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Project 2");
        try {
            while (refrigeratorContext == null) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
        primaryStage.show();
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent window) {
                System.exit(0);
            }
        });
    }
    
    /**
     * satisfying RefrigeratorDisplay interface
     */
   
    
    /**
     * Indicate that the light is on
     */
    public void showLightOn() {
        lightStatus.setText("Light On");
    }

    /**
     * Indicate that the light is off
     */
    public void showLightOff() {
        lightStatus.setText("Light Off");
    }

    /**
     * Indicate that the door is now closed
     */
    @Override
    public void showDoorClosed() {
        doorStatus.setText("Door Closed");
    }

    /**
     * Indicate that the door is now open
     */
    @Override
    public void showDoorOpened() {
        doorStatus.setText("Door Opened");
    }
    
    /**
     * Indicate refrigerator is off
     */
    public void showRefrigeratorOff(){
        powerStatus.setText("Fridge Off");
    }
    /**
     * Indicate refrigerator is on
     */
    public void showRefrigeratorOn(){
        powerStatus.setText("Fridge On");
    }

    /**
     * Indicate that refrigerator is not cooling
     */
    public void showRefrigeratorCoolingOff() {
    	coolingStatus.setText("Cooling Off");
    }
    
    /**
     * Indicate that refrigerator is  cooling
     */
    public void showRefrigeratorCoolingOn() {
    	coolingStatus.setText("Cooling On");
    }
    
    /**
     * Indicate inside temperature
     */
    public void showInternalTemperature() {
    	//TODO
    }
   
    /**
     * Indicate outside temperature
     */
    public void showExternalTemperature() {
    	//TODO
  }
}
