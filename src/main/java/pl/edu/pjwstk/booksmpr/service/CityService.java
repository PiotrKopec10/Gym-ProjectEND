package pl.edu.pjwstk.booksmpr.service;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.dto.CityDTO;
import pl.edu.pjwstk.booksmpr.model.dto.ResultCityDTO;

import java.io.IOException;

@Service
public class CityService {

    public String[] findLatitudeAndLongitude(String cityName) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = "http://geocoding-api.open-meteo.com/v1/search?name=" + cityName;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Gson gson = new Gson();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ResultCityDTO result = gson.fromJson(responseBody.string(), ResultCityDTO.class);

        CityDTO city = result.getResults().stream()
                .filter(u -> u.getName().equals(cityName))
                .findFirst()
                .orElse(null);

        if (city != null) {
            return new String[]{city.getLatitude(), city.getLongitude()};
        }

        return new String[]{"0", "0"};
    }
}
