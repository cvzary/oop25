import java.time.LocalTime;
import java.util.Locale;

public class MinuteHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = time.getMinute() * 6 + time.getSecond() * 0.1;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH,"<line x1=\"200\" y1=\"200\" x2=\"200\" y2=\"90\" "+
                "stroke=\"black\" stroke-width=\"4\" "+
                "transform=\"rotate(%.1f,200,200)\" />", angle);
    }
}
