package pl.edu.pjwstk.booksmpr.service;

import pl.edu.pjwstk.booksmpr.common.LocalDateTimeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.dto.ResultCityDTO;
import pl.edu.pjwstk.booksmpr.model.dto.TemperatureDTO;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class WeatherService {

    @Autowired
    private CityService cityService;

    public String getCurrentTemperature(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String[] coordinats;
        try {
            coordinats = cityService.findLatitudeAndLongitude(city);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(coordinats[0].equals("0") && coordinats[1].equals("0")){
            throw new IllegalArgumentException();
        }

        String url = "http://api.open-meteo.com/v1/forecast?latitude=" + coordinats[0] + "&longitude=" + coordinats[1] + "&hourly=temperature_2m";

        Request request = new Request.Builder()
                .url(url)
                .build();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();
        ResponseBody responseBody = client.newCall(request).execute().body();
        TemperatureDTO result = gson.fromJson(responseBody.string(), TemperatureDTO.class);

        return getProperTemperature(result);

    }

    private String getProperTemperature(TemperatureDTO result) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = result.getHourly().getTime().get(0);
        int i = 0;
        while (now.isAfter(time)) {
            i++;
            time = result.getHourly().getTime().get(i);
        }
        return result.getHourly().getTemperature_2m().get(i).toString();
    }
}
