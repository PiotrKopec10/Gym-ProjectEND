package pl.edu.pjwstk.booksmpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.booksmpr.service.WeatherService;
;
import java.io.IOException;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) throws IOException {
        return ResponseEntity.ok("Aktualna temperatura w " + city + " " + weatherService.getCurrentTemperature(city));
    }


}
