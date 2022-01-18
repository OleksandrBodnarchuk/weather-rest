package pl.alex.wearher.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "56ef07a391a083c2cc07941f43640370";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getWeatherForCity(String city) {
        return callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=PL", String.class,
                city, API_KEY);
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl", String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
