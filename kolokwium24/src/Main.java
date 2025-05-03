import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        DigitalClock clock24 = new DigitalClock(DigitalClock.ClockMode.H24);
//        DigitalClock myclock = new DigitalClock(DigitalClock.ClockMode.H12);
//
//        clock24.setCurrentTime();
//        myclock.setTime(12,36,48);
        String filePath = "kolokwium24/strefy.csv";
        Map<String, City> cities = City.parseFile(filePath);
//        for(City city : cities.values()) {
//            System.out.println("Miasto: " + city.getCityName());
//            System.out.println("Strefa czasowa: " + city.getTimezone());
//            System.out.println("Szerokosc geograficzna: " + city.getLatitude());
//            System.out.println("Dlugosc geograficzna: " +city.getLongitude());
//            System.out.println();
//        }
        City warsaw = cities.get("Warszawa");
//        DigitalClock clock1 = new DigitalClock(DigitalClock.ClockMode.H24, warsaw);
//        System.out.println(clock1);
//        clock1.setCity(moskwa);
//        System.out.println(clock1);

          City lublin = cities.get("Lublin");
//        DigitalClock clock12 = new DigitalClock(DigitalClock.ClockMode.H12, lublin);
//        clock12.setCurrentTime();
//        System.out.println(clock12);
//        LocalTime lublinTime = LocalTime.of(12,0,0);
//        LocalTime localTime = lublin.localMeanTime(lublinTime);

//        System.out.println("Godzina 12 w Lublinie strefowo: " + lublinTime);
//        System.out.println("Godzina 12 w Lublinie ale miejscowo(dokladnie) " + localTime);

//        List<City> cityList = new ArrayList<>(cities.values());
//        cityList.sort(City.worstTimezoneFit());
//        for(City city : cityList) {
//            System.out.println(city.getCityName());
//        }


        City moskwa = cities.get("Moskwa");
        AnalogClock clock = new AnalogClock(moskwa);
        System.out.println(clock);
        clock.toSvg("zegar.svg");

    }
}