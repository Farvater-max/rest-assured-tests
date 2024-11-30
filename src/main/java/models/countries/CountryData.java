package models.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CountryData {

    @JsonProperty("name")
    private CountryName name;

    @JsonProperty("independent")
    private Boolean independent;

    @JsonProperty("region")
    private String region;

    @JsonProperty("area")
    private Integer area;

    @JsonProperty("continents")
    private List<String> continents;

}
