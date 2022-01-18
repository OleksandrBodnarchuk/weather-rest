package pl.alex.wearher.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class WeatherForecastDTO {
    private Date today;
    private Date sunrise;
    private Date sunset;
    private float temperature;
    private float feelsLike;
    private String humidity;
    private List<WeatherDailyDTO> daily;
}
