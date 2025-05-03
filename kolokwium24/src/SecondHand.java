import java.time.LocalTime;
import java.util.Locale;

public class SecondHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = time.getSecond() * 6; // 360 stopni na 60 sekund to 1 sek = 6 stopni
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH,"<line x1=\"200\" y1=\"200\" x2=\"200\" y2=\"70\" "+
                "stroke=\"red\" stroke-width=\"2\" "+
                "transform=\"rotate(%.1f,200,200)\" />", angle);
    }
}
