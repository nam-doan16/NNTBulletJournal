package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeekJson(
    @JsonProperty("Maxt") int maxt,
    @JsonProperty("Maxe") int maxe,
    @JsonProperty("Theme") String theme,
    @JsonProperty("QandN") String notes,
    @JsonProperty("AllTasks") TaskJson[] tasks,
    @JsonProperty("AllEvents") EventJson[] events,
    @JsonProperty("Start") String start
){}
