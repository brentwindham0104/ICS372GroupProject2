package gui;

import buttons.GUIButton;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application implements RefrigeratorDisplay {
    private GUIButton powerButton;
    private GUIButton doorButton;

    private TextField externalTemperatureInput;
    private TextField internalTemperatureInput;
    
    private Text actualTemperature;
    private Text powerStatus;
    private Text doorStatus;
    private Text coolingStatus;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void showInternalTemperature() {

    }

    @Override
    public void showExternalTemperature() {

    }

    @Override
    public void showPower() {

    }

    @Override
    public void showDoor() {

    }

    @Override
    public void showLight() {

    }

    @Override
    public void showCooling() {

    }
}
