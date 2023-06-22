package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.enums.Days;

public record TaskJson(
    @JsonProperty("Name") String name,
    @JsonProperty("Description") String details,
    @JsonProperty("Day") Days day,
    @JsonProperty("Link") String link,
    @JsonProperty("Complete") boolean done
) {
}
