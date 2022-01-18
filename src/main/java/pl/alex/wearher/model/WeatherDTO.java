package pl.alex.wearher.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDTO {
    private float temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;

}
