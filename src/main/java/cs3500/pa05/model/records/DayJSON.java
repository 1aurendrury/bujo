package cs3500.pa05.model.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import java.util.List;

public record DayJSON(
    @JsonProperty("events") List<Event> events,
    @JsonProperty("tasks") List<Task> tasks,
    @JsonProperty("maxEvents") int maxEvents,
    @JsonProperty("events") int maxTasks) {

}
