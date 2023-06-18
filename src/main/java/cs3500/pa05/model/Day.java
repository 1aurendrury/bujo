package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Day {
  @JsonProperty("events")
  private List<Event> events;

  @JsonProperty("tasks")
  private List<Task> tasks;

  @JsonProperty("max-events")
  private int maxEvents;

  @JsonProperty("max-tasks")
  private int maxTasks;

  public Day (
      @JsonProperty("events") List<Event> events,
      @JsonProperty("tasks") List<Task> tasks,
      @JsonProperty("max-events") int maxEvents,
      @JsonProperty("max-tasks") int maxTasks) {
    this.events = events;
    this.tasks = tasks;
    this.maxEvents = maxEvents;
    this.maxTasks = maxTasks;
  }

  public void addEvent(Event event) {
    events.add(event);
  }

  public void addTasks(Task task) {
    tasks.add(task);
  }
}
