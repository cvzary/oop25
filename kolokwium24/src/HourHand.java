import java.time.LocalTime;
import java.util.Locale;

public class HourHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        // kazda godzina to 30 stopni, 360 / 12 = 30 // kazda minuta przesuwa o 0.5 stopnia -//- sekunda o 0.5/60
        this.angle = (time.getHour() % 12) * 30 + time.getMinute() * 0.5 + time.getSecond() * (0.5 / 60);
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH,"<line x1=\"200\" y1=\"200\" x2=\"200\" y2=\"130\" "+
                "stroke=\"black\" stroke-width=\"6\" "+
                "transform=\"rotate(%.1f,200,200)\" />", angle);
    }

}