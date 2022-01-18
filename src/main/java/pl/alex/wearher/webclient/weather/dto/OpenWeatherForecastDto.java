package pl.alex.wearher.webclient.weather.dto;

import lombok.Getter;
import lombok.ToString;
import pl.alex.wearher.webclient.weather.dto.forecast.OpenWeatherCurrentDto;
import pl.alex.wearher.webclient.weather.dto.forecast.OpenWeatherDailyDto;

import java.util.List;

@Getter
@ToString
public class OpenWeatherForecastDto {
    private OpenWeatherCurrentDto current;
    private List<OpenWeatherDailyDto> daily;

}
