import java.time.LocalTime;

public abstract class Clock {
    private int hour;
    private int minute;
    private int second;
    private City city;

    public Clock(City city) {
        this.city = city;
        setCurrentTime();
    }

    public LocalTime setCurrentTime() {
        LocalTime now = LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
        return now;
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Godzina nie miesci sie w zakresie 0-23!\t Podano; "+hour);
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("Minuty nie mieszcza sie w zakresie 0-59!\t Podano; "+minute);
        if (second < 0 || second > 59)
            throw new IllegalArgumentException("Sekundy nie mieszcza sie w zakresie 0-59!\t Podano; "+second);

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setCity(City newCity) {
        int timeDifference = newCity.getTimezone() - this.city.getTimezone();
        this.hour = (this.hour + timeDifference) % 24;
        if(this.hour < 0) this.hour += 24;
        this.city = newCity;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

}
