package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.enums.Days;

public record EventJson(
    @JsonProperty("Title") String name,
    @JsonProperty("Description") String details,
    @JsonProperty("Start") String start,
    @JsonProperty("Duration") int time,
    @JsonProperty("Day") Days day,
    @JsonProperty("Link") String link
) {
}
