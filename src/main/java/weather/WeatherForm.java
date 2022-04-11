package weather;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherForm extends JFrame {
    static HashMap<String, String> mapWind;
    static HashMap<String, String> mapCondition;
    static {
        mapWind = new HashMap<>();
        mapWind.put("nw","северо-западное");
        mapWind.put("n","северное");
        mapWind.put("ne","северо-восточное");
        mapWind.put("e","восточное");
        mapWind.put("se","юго-восточное");
        mapWind.put("s","южное");
        mapWind.put("sw","юго-западное");
        mapWind.put("w","западное");
        mapWind.put("c","штиль");

        mapCondition = new HashMap<>();
        mapCondition.put("clear","ясно.");
        mapCondition.put("partly-cloudy","малооблачно.");
        mapCondition.put("cloudy","облачно с прояснениями.");
        mapCondition.put("overcast","пасмурно.");
        mapCondition.put("drizzle","морось.");
        mapCondition.put("light-rain","небольшой дождь.");
        mapCondition.put("rain","дождь.");
        mapCondition.put("moderate-rain","умеренно сильный дождь.");
        mapCondition.put("heavy-rain","сильный дождь.");
        mapCondition.put("continuous-heavy-rain","длительный сильный дождь.");
        mapCondition.put("showers","ливень.");
        mapCondition.put("wet-snow","дождь со снегом.");
        mapCondition.put("light-snow","небольшой снег.");
        mapCondition.put("snow","снег.");
        mapCondition.put("snow-showers","снегопад.");
        mapCondition.put("hail","град.");
        mapCondition.put("thunderstorm","гроза.");
        mapCondition.put("thunderstorm-with-rain","дождь с грозой.");
        mapCondition.put("thunderstorm-with-hail","гроза с градом.");
    }


    private RootWeather rootWeather;

    public WeatherForm(RootWeather rootWeather) throws HeadlessException {
        this.rootWeather = rootWeather;
        setBounds(300,300,300,300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage image = null;
        try {
            String imageUrl = "https://yastatic.net/weather/i/icons/funky/dark/"
                    + rootWeather.fact.icon + ".svg";
            image = ImageIO.read(new URL(imageUrl));
            g.drawImage(image,20,20,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawString("температура " + rootWeather.fact.temp,20,60);
        g.drawString("погодное состояние " + mapCondition.get(rootWeather.fact.condition),20,75);
        g.drawString("ощущается как" + rootWeather.fact.feels_like,20,90);
        g.drawString(rootWeather.fact.wind_speed+" м/с, направление " + mapWind.get(rootWeather.fact.wind_dir),20,105);
        g.drawString(rootWeather.fact.pressure_mm+" мм.рт.ст",20,120);


    }


}
