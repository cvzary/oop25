import java.time.LocalTime;

public abstract class Clock {
    private int hour;
    private int minute;
    private int second;
    private City city;


    public Clock(City city) {
        this.city = city;
        setCurrentTime();// dziala dla nowej implementacji automatyznie ustawiajac wlasc godzine
    }


    public void setCurrentTime() {
        LocalTime utcTime = LocalTime.now(java.time.Clock.systemUTC());
        LocalTime currentTime = utcTime.plusHours(city.getTimezone());
        //LocalTime now = LocalTime.now(); nieprawidlowe dzialanie dla miast innych niz Polskie
        this.hour = currentTime.getHour();
        this.minute = currentTime.getMinute();
        this.second = currentTime.getSecond();
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
        int timeDifference = newCity.getTimezone() - this.city.getTimezone();;
        this.hour = (this.hour + timeDifference) % 24;
        if (this.hour < 0) this.hour += 24;
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
