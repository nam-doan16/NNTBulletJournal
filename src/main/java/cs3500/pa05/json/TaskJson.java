package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskJson(
    @JsonProperty("Name") String name,
    @JsonProperty("Description") String details
) {
}