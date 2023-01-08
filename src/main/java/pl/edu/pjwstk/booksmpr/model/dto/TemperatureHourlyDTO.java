package pl.edu.pjwstk.booksmpr.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TemperatureHourlyDTO {
    List<LocalDateTime> time;
    List<Double> temperature_2m;

    public TemperatureHourlyDTO() {
    }

    public TemperatureHourlyDTO(List<LocalDateTime> time, List<Double> temperature_2m) {
        this.time = time;
        this.temperature_2m = temperature_2m;
    }

    public List<LocalDateTime> getTime() {
        return time;
    }

    public void setTime(List<LocalDateTime> time) {
        this.time = time;
    }

    public List<Double> getTemperature_2m() {
        return temperature_2m;
    }


}
