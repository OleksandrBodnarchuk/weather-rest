package pl.alex.wearher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.alex.wearher.model.WeatherDTO;
import pl.alex.wearher.model.WeatherForecastDTO;
import pl.alex.wearher.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public WeatherDTO getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }

    @GetMapping("/weather/forecast/{city}")
    public WeatherForecastDTO getWeatherForecast(@PathVariable String city) {
        return weatherService.getForecast(city);
    }
}
