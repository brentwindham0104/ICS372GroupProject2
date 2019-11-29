package timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import events.TimerTickedEvent;

/**
 * The timer allows a certain time period to be set when created. It sends
 * signals back to its creator every second and a timer runs out message when
 * the time period has elapsed.
 */
public class Timer implements PropertyChangeListener {
    private int timeValue;
    private Notifiable client;

    /**
     * Sets up the timer for a certain client with an initial time value
     *
     * @param client
     *            the client, a Notifiable object
     * @param timeValue
     *            the initial time value after which the timer runs out of time.
     */
    public Timer(Notifiable client, int timeValue) {
        this.client = client;
        this.timeValue = timeValue;
        Clock.instance().addPropertyChangeListener(this);
    }

    /**
     * Returns the current seconds value
     *
     * @return the time current seconds value
     */
    public int getTimeValue() {
        return timeValue;
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        if (timeValue == (timeValue + 1)) {
        	 client.handleEvent(new TimerTickedEvent(timeValue));
        } else {
        	//Do nothing
        };                 
    }
}