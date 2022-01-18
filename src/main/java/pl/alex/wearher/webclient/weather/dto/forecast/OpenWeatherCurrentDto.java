package pl.alex.wearher.webclient.weather.dto.forecast;

import lombok.Getter;

@Getter
public class OpenWeatherCurrentDto {
    private long dt;
    private long sunrise;
    private long sunset;
    private float temp;
    private float feels_like;
    private int humidity;
}
