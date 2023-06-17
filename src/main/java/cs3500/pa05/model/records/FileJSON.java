package cs3500.pa05.model.records;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Day;
import java.util.List;

public record FileJSON(
    @JsonProperty("theme") String theme,
    @JsonProperty("name") String name,
    @JsonProperty("days") List<Day> days) {
}
