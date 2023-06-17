package cs3500.pa05.model.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TasksJSON(
    @JsonProperty("name") String name,
    @JsonProperty("desc") String desc,
    @JsonProperty("day") String day,
    @JsonProperty("isComplete") boolean isComplete) {
}
