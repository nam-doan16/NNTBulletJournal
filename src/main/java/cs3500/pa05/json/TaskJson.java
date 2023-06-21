package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.enums.Days;

public record TaskJson(
    @JsonProperty("Name") String name,
    @JsonProperty("Description") String details,
    @JsonProperty("Day") Days day
) {
}
