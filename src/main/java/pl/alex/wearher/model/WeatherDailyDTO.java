package pl.alex.wearher.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Getter
@Builder
public class WeatherDailyDTO {
    private Date date;
    private Date sunrise;
    private Date sunset;
    private float dayTemp;
    private float minimumTemp;
    private float maximumTemp;
    private float night;
    private float evening;
    private float morning;
}
