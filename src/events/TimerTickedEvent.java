package events;

/**
 * This class represents a clock tick. The object contains the seconds
 * value in timer
 */
public class TimerTickedEvent extends RefrigeratorEvent {
    private int currentSeconds;

    /**
     * Stores the amount of time left in the Timer.
     * 
     * @param value
     *            the current seconds value
     */
    public TimerTickedEvent(int value) {
        this.currentSeconds = value;
    }

    /**
     * Needed for display purposes
     */
    public int getTimeLeft() {
        return currentSeconds;
    }
}
