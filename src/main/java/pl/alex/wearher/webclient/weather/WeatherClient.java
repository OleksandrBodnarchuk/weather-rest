package pl.alex.wearher.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.alex.wearher.model.WeatherDTO;
import pl.alex.wearher.webclient.weather.dto.OpenWeatherWeatherDto;

import java.util.Date;

@Component
public class WeatherClient {
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "56ef07a391a083c2cc07941f43640370";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDTO getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = getOpenWeatherWeatherDtoByCity(city);
        return WeatherDTO.builder()
                .city(openWeatherWeatherDto.getName())
                .date(new Date(openWeatherWeatherDto.getDt()*1000))
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .temp_min(openWeatherWeatherDto.getMain().getTemp_min())
                .temp_max(openWeatherWeatherDto.getMain().getTemp_max())
                .feelsLike(openWeatherWeatherDto.getMain().getFeels_like())
                .humidity(openWeatherWeatherDto.getMain().getHumidity()+"%") // to String
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = getOpenWeatherWeatherDtoByCity(city);
        double lat = openWeatherWeatherDto.getCoord().getLat();
        double lon = openWeatherWeatherDto.getCoord().getLon();
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl", String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }

    private OpenWeatherWeatherDto getOpenWeatherWeatherDtoByCity(String city) {
        return callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=PL", OpenWeatherWeatherDto.class,
                city, API_KEY);
    }
}
