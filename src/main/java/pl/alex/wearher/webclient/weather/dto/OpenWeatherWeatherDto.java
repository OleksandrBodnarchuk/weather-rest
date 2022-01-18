package pl.alex.wearher.webclient.weather.dto;

import lombok.Getter;
import pl.alex.wearher.webclient.weather.dto.city.OpenWeatherCityCoordinatesDto;
import pl.alex.wearher.webclient.weather.dto.city.OpenWeatherMainDto;
import pl.alex.wearher.webclient.weather.dto.city.OpenWeatherWindDto;

@Getter
public class OpenWeatherWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
    private long dt;
    private String name;
    private OpenWeatherCityCoordinatesDto coord;

}
