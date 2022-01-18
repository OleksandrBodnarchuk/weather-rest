package pl.alex.wearher.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class WeatherDTO {
    private String city;
    private Date date;
    private float temperature;
    private float temp_min;
    private float temp_max;
    private float feelsLike;
    private String humidity;
    private float windSpeed;

}
