package states;

import events.*;
import gui.RefrigeratorDisplay;

public class RefrigeratorContext {
    private RefrigeratorDisplay display;
    private RefrigeratorState currentState;
    private RefrigeratorContext instance;

    private RefrigeratorContext() {}

    public RefrigeratorContext getInstance() {
        if (instance == null) {
            instance = new RefrigeratorContext();
        }

        return instance;
    }

    public void changeState(RefrigeratorState state) {
        currentState.leave();
        currentState = state;
        currentState.enter();
    }

    public void handleEvent(PowerOnEvent event) {
        currentState.handleEvent(event);
    };

    public void handleEvent(PowerOffEvent event) {
        currentState.handleEvent(event);
    };

    public void handleEvent(DoorOpenEvent event) {
        currentState.handleEvent(event);
    };

    public void handleEvent(DoorCloseEvent event) {
        currentState.handleEvent(event);
    };

    public void handleEvent(CoolingOnEvent event) {
        currentState.handleEvent(event);
    };

    public void handleEvent(CoolingOffEvent event) {
        currentState.handleEvent(event);
    };
}
