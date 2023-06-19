package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DayJson(
    @JsonProperty("Day") String day,
    @JsonProperty("Tasks") TaskJson[] tasks,
    @JsonProperty("Events") EventJson[] events
) {
}
