package events;

public class TemperatureChanged {
        private static TemperatureChanged instance;

        private TemperatureChanged() {

        }

        public static TemperatureChanged getInstance() {
            if (instance == null) {
                instance = new TemperatureChanged();
            }

            return instance;
        }

}
