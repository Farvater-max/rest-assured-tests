package models.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class ObjectData {

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("CPU model")
    private String cpu_model;

    @JsonProperty("Hard disk size")
    private String hard_disk_size;
}
