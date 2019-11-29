package timer;


import events.TimerTickedEvent;

/**
 * An entity that can be notified of timing events
 */
public interface Notifiable {
    /**
     * Process timer ticks
     */
    public void handleEvent(TimerTickedEvent event);


}
