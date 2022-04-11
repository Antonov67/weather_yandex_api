package weather;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class RootWeather {
    public double now;
    public String now_dt;

    @SerializedName("info")
    public Info info;
    @SerializedName("fact")
    public Fact fact;
    @SerializedName("forecasts")
    public List<Forecast> forecasts;

    @Override
    public String toString() {
        return "RootWeather{" +
                "now=" + now +
                ", now_dt='" + now_dt + '\'' +
                ", info=" + info +
                ", fact=" + fact +
                ", forecasts=" + forecasts +
                '}';
    }

}
