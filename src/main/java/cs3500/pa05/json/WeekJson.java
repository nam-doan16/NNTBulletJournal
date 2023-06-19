package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeekJson(
    @JsonProperty("Theme") String theme,
    @JsonProperty("QandN") String notes,
    @JsonProperty("AllTasks") TaskJson[] tasks
  ){}
