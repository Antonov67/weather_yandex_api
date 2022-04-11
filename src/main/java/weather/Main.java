package weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    static String WEATHER_URL = "https://api.weather.yandex.ru/v2/forecast?lat=54.78263474&lon=32.04528809&limit=3&extra=true";

    public static void main(String[] args) {
        Gson gson = new Gson();
        RootWeather rootWeather = gson.fromJson(getStringFromServer(WEATHER_URL),RootWeather.class);
//        System.out.println(rootWeather);
        new WeatherForm(rootWeather);

    }

    //подключение к серверу для получения данных в виде строки
    static StringBuffer content;
    static HttpURLConnection connection;


    static String getStringFromServer(String urlAdress){
        BufferedReader reader;
        String line;
        content = new StringBuffer();
        //
        try {
            URL url = new URL(urlAdress);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Yandex-API-Key","f9ced9df-c14d-401a-8675-b44f48b1f745");
            if (connection.getResponseCode() == 200){
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null){
                    content.append(line);
                }
                reader.close();
            }
            else {
                System.out.println("не-а" + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }


        return content.toString();
    }
}
