import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class AnalogClock extends Clock {

    public AnalogClock(City city) {
        super(city);
    }

    private final List<ClockHand> hands = Arrays.asList(
            new HourHand(),
            new MinuteHand(),
            new SecondHand()
    );


    public void toSvg(String filePath) {
        int centerX = 200;
        int centerY = 200;
        int radius = 140;
        int clockSize = 2 * radius;
        LocalTime time = setCurrentTime();

        for (ClockHand hand : hands) {
            hand.setTime(time);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("<svg height=\"400\" width=\"400\" xmlns=\"http://www.w3.org/2000/svg\">\n");
            writer.write("<circle r=\"140\" cx=\"200\" cy=\"200\" fill=\"none\" stroke=\"black\" stroke-width=\"3\" />\n");

            for (ClockHand hand : hands) {
                writer.write(hand.toSvg() + "\n");
            }
            writer.write("</svg>");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}