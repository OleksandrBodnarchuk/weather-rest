package pl.alex.wearher.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.alex.wearher.model.WeatherDTO;
import pl.alex.wearher.service.WeatherService;

@RestController
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDTO getWeather() {
        return weatherService.getWeather();
    }
}
