package models.countries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CountryName {

    @JsonProperty("common")
    private String common;

    @JsonProperty("official")
    private String official;
}
