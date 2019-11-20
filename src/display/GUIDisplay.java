package display;

import buttons.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIDisplay extends Application implements RefrigeratorDisplay {
    private GUIToggleButton powerButtonOn;
    private GUIToggleButton powerButtonOff;
    private GUIToggleButton doorButtonOpen;
    private GUIToggleButton doorButtonClose;

    private TextField externalTemperatureInput;
    private TextField internalTemperatureInput;

    private Text actualTemperature;
    private Text powerStatus;
    private Text doorStatus;
    private Text coolingStatus;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Refrigerator 9000");
        Scene scene = refrigeratorSceneSetup(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Scene refrigeratorSceneSetup(Stage stage) {
        Group root = new Group();
        Insets insets = new Insets(10, 10, 10, 10);
        BorderPane borderPane = new BorderPane();
        Scene refrigeratorScene = new Scene(root, 600, 400);

        powerButtonOn = new PowerButtonOn("On");
        powerButtonOff = new PowerButtonOff("Off");
        doorButtonOpen = new DoorButtonOpen("Open");
        doorButtonClose = new DoorButtonClose("Close");

        // Add buttons to respective toggle group
        ToggleGroup powerButtonGroup = new ToggleGroup();
        ToggleGroup doorButtonGroup = new ToggleGroup();
        addTogglesToGroup(powerButtonGroup, powerButtonOff, powerButtonOn);
        addTogglesToGroup(doorButtonGroup, doorButtonClose, doorButtonOpen);

        // Add buttons to respective gridPane
        Label powerLabel = labelSetup("Power", 14.0);
        Label doorLabel = labelSetup("Door", 14.0);

        GridPane powerButtonGridPane = gridPaneSetup(powerLabel, powerButtonOff, powerButtonOn);
        GridPane doorButtonGridPane = gridPaneSetup(doorLabel, doorButtonClose, doorButtonOpen);

        // Add grids to vbox
        VBox leftMenu = new VBox();
        leftMenu.setMinWidth(100.0);
        leftMenu.setFillWidth(true);
        Label title = labelSetup("Controls", 18.0);
        GridPane titleGridPane = new GridPane();
        titleGridPane.add(title, 0, 0);
        leftMenu.getChildren().addAll(titleGridPane, powerButtonGridPane, doorButtonGridPane);

        // Add menu to border pane
        borderPane.setLeft(leftMenu);

        // Add borderPane to root
        root.getChildren().add(borderPane);

        return refrigeratorScene;
    }

    private void addTogglesToGroup(ToggleGroup toggleGroup, ToggleButton...toggleButtons) {
        for (ToggleButton toggleButton: toggleButtons) {
            toggleButton.setToggleGroup(toggleGroup);
        }
    }

    private Label labelSetup(String name, Double fontSize) {
        Label label = new Label(name);

        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("System", FontWeight.BOLD, fontSize));

        return label;
    }

    private GridPane gridPaneSetup(Label label, GUIToggleButton negative, GUIToggleButton positive) {
        GridPane gridPane = new GridPane();
        gridPane.setPrefWidth(Double.MAX_VALUE);
        gridPane.setGridLinesVisible(true);

        gridPane.paddingProperty().setValue(new Insets(10, 10, 10, 10));
        gridPane.add(label, 0, 0, 2, 1);

        gridPane.add(negative, 0, 1);
        gridPane.add(positive, 1, 1);

        gridPane.getColumnConstraints();
        return gridPane;
    }

    @Override
    public void showInternalTemperature() {

    }

    @Override
    public void showExternalTemperature() {

    }

    @Override
    public void showRefrigeratorOn() {

    }

    @Override
    public void showRefrigeratorOff() {

    }

    @Override
    public void showDoorOpened() {

    }

    @Override
    public void showDoorClosed() {

    }

    @Override
    public void showLightOn() {

    }

    @Override
    public void showLightOff() {

    }

    @Override
    public void showRefrigeratorCoolingOn() {

    }

    @Override
    public void showRefrigeratorCoolingOff() {

    }
}
