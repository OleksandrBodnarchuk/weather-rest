package pl.alex.wearher.webclient.weather.dto.forecast;

import lombok.Getter;

@Getter
public class OpenWeatherForecastTemp {
    private float day;
    private float min;
    private float max;
    private float night;
    private float eve;
    private float morn;
}
