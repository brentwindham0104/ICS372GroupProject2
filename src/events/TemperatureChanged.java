/**
 * This class implements the event for a change in temperature
 * @author Brentwindham
 */
package events;

public class TemperatureChanged {
        private static TemperatureChanged instance;

        /**
         * Constructor for temperatureChanged
         */
        private TemperatureChanged() {

        }

        /**
         * Singleton implementation for TemperatureChanged
         * @return Returns instance of TemperatureChanged
         */
        public static TemperatureChanged getInstance() {
            if (instance == null) {
                instance = new TemperatureChanged();
            }

            return instance;
        }

}
