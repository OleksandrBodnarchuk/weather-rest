package pl.alex.wearher.webclient.weather.dto.city;

import lombok.Getter;

@Getter
public class OpenWeatherMainDto {
    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private int humidity;

}
