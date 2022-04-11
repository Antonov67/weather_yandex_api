package weather;

public class Forecast {
    public String date;
    public String sunrise;
    public String sunset;

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}
