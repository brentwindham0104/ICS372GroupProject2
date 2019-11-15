package states;

import events.*;

public abstract class RefrigeratorState {
    public void enter(){};
    public void leave(){};
    public void handleEvent(PowerOnEvent event){};
    public void handleEvent(PowerOffEvent event){};
    public void handleEvent(DoorOpenEvent event){};
    public void handleEvent(DoorCloseEvent event){};
    public void handleEvent(CoolingOnEvent event){};
    public void handleEvent(CoolingOffEvent event){};
}
