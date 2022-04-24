package com.letscode811.microservicesHogwarts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseKey {
    @JsonProperty("sorting-hat-choice")
    private String sortingHatChoice;
}
