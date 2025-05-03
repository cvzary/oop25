public class DigitalClock extends Clock {
    public enum ClockMode {
        H12,
        H24
    }

    private ClockMode mode;

    public DigitalClock(ClockMode mode, City city) {
        super(city);
        this.mode = mode;
    }

    @Override
    public String toString() {
        if (mode == ClockMode.H24) {
            return super.toString();
        } else {
            int hour12 = getHour();
            String ampm;

            if (hour12 == 0) {
                hour12 = 12;
                ampm = "AM";
            }
            else if (hour12 == 12) {
                hour12 = 12;
                ampm = "PM";
            }
            else if (hour12 > 12) {
                hour12 = hour12 - 12;
                ampm = "PM";
            } else {
                ampm = "AM";
            }

            return hour12 + ":" + String.format("%02d", getMinute()) + ":" + String.format("%02d ", getSecond()) + ampm;
        }

    }

}
