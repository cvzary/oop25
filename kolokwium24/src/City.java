import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class City {
    private final String cityName;
    private final int timezone;
    private final String latitude;
    private final String longitude;

    public City(String cityName, int timezone, String latitude, String longitude) {
        this.cityName = cityName;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocalTime localMeanTime(LocalTime time) {
        String[] parts = longitude.split(" ");
        double degrees = Double.parseDouble(parts[0]);
        String direction = parts[1];
        if (direction.equals("W")) {
            degrees = -degrees;
        }

        double zoneLongitude = timezone * 15;
        double longitudeDiff = degrees - zoneLongitude;
        long diffSec = Math.round(longitudeDiff * 240); // 1 stopien = 4 min = 4*60 = 240 sekund

        return time.plusSeconds(diffSec);
    }

    private static City parseLine(String line) {
        String[] parts = line.split(",");

        if (parts.length == 4) {
            String cityName = parts[0].trim();
            int timezone = Integer.parseInt(parts[1].trim());
            String latitude = parts[2].trim();
            String longitude = parts[3].trim();

            return new City(cityName, timezone, latitude, longitude);
        }

        return null;
    }

    public static Map<String, City> parseFile(String filePath) {
        Map<String, City> cities = new HashMap<>();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                City city = parseLine(line);
                if (city != null) {
                    cities.put(city.getCityName(), city);
                }
            }
        } catch (java.io.IOException e) {
            e.getMessage();
        }
        return cities;
    }

    public static Comparator<City> worstTimezoneFit() {
        return new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                LocalTime baseTime = LocalTime.of(12, 0, 0);
                long diff1 = Math.abs(Duration.between(baseTime, c1.localMeanTime(baseTime)).getSeconds());
                long diff2 = Math.abs(Duration.between(baseTime, c2.localMeanTime(baseTime)).getSeconds());

                return Long.compare(diff2, diff1);
            }
        };
    }


        public String getCityName () {
            return cityName;
        }

        public int getTimezone () {
            return timezone;
        }

        public String getLatitude () {
            return latitude;
        }

        public String getLongitude () {
            return longitude;
        }
    }