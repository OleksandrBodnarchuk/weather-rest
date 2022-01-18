package pl.alex.wearher.webclient.weather.dto.forecast;

import lombok.Getter;

@Getter
public class OpenWeatherDailyDto {
    private long dt;
    private long sunrise;
    private long sunset;
    private OpenWeatherForecastTemp temp;
}
