package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EventJson(
    @JsonProperty("Title") String name,
    @JsonProperty("Description") String details,
    @JsonProperty("Start") int start,
    @JsonProperty("Duration") int time
) {
}
