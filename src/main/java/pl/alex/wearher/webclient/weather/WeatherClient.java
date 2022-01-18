package pl.alex.wearher.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.alex.wearher.model.WeatherDTO;
import pl.alex.wearher.model.WeatherDailyDTO;
import pl.alex.wearher.model.WeatherForecastDTO;
import pl.alex.wearher.webclient.weather.dto.OpenWeatherForecastDto;
import pl.alex.wearher.webclient.weather.dto.OpenWeatherWeatherDto;
import pl.alex.wearher.webclient.weather.dto.forecast.OpenWeatherDailyDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class WeatherClient {
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "56ef07a391a083c2cc07941f43640370";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDTO getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = getOpenWeatherWeatherDtoByCity(city);
        return WeatherDTO.builder()
                .city(openWeatherWeatherDto.getName())
                .date(new Date(openWeatherWeatherDto.getDt() * 1000))
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .temp_min(openWeatherWeatherDto.getMain().getTemp_min())
                .temp_max(openWeatherWeatherDto.getMain().getTemp_max())
                .feelsLike(openWeatherWeatherDto.getMain().getFeels_like())
                .humidity(openWeatherWeatherDto.getMain().getHumidity() + "%") // to String
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    public WeatherForecastDTO getForecast(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = getOpenWeatherWeatherDtoByCity(city);
        double lat = openWeatherWeatherDto.getCoord().getLat();
        double lon = openWeatherWeatherDto.getCoord().getLon();
        OpenWeatherForecastDto forecastDto = callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherForecastDto.class,
                lat, lon, API_KEY);
        return WeatherForecastDTO.builder()
                .today(new Date(forecastDto.getCurrent().getDt() * 1000))
                .sunrise(new Date(forecastDto.getCurrent().getSunrise() * 1000))
                .sunset(new Date(forecastDto.getCurrent().getSunset() * 1000))
                .temperature(forecastDto.getCurrent().getTemp())
                .feelsLike(forecastDto.getCurrent().getFeels_like())
                .humidity(forecastDto.getCurrent().getHumidity() + "%")
                .daily(mapToDailyDto(forecastDto.getDaily()))
                .build();

    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }

    private OpenWeatherWeatherDto getOpenWeatherWeatherDtoByCity(String city) {
        return callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=PL", OpenWeatherWeatherDto.class,
                city, API_KEY);
    }

    private List<WeatherDailyDTO> mapToDailyDto(List<OpenWeatherDailyDto> daily) {
        List<WeatherDailyDTO> weatherDailyDTOS = new ArrayList<>();
        for (OpenWeatherDailyDto d : daily) {
            weatherDailyDTOS.add(WeatherDailyDTO.builder()
                    .date(new Date(d.getDt() * 1000))
                    .sunrise(new Date(d.getSunrise() * 1000))
                    .sunset(new Date(d.getSunset() * 1000))
                    .dayTemp(d.getTemp().getDay())
                    .minimumTemp(d.getTemp().getMin())
                    .maximumTemp(d.getTemp().getMax())
                    .night(d.getTemp().getNight())
                    .evening(d.getTemp().getEve())
                    .morning(d.getTemp().getMorn())
                    .build());
        }
        return weatherDailyDTOS;
    }
}
