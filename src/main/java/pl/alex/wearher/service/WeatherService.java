package pl.alex.wearher.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.alex.wearher.model.WeatherDTO;
import pl.alex.wearher.webclient.weather.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDTO getWeather() {
        String response = weatherClient.getWeatherForCity("warszawa");
        log.info(response);
        response = weatherClient.getForecast(52.23,21.01);
        log.info(response);
        return null;
    }


}
