package pl.edu.pjwstk.booksmpr.model.dto;

import java.util.List;

public class ResultCityDTO {
    private List<CityDTO> results;

    public ResultCityDTO() {
    }

    public ResultCityDTO(List<CityDTO> results) {
        this.results = results;
    }

    public List<CityDTO> getResults() {
        return results;
    }


}

