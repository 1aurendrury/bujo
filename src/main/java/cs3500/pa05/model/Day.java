package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Day {
  @JsonProperty("events")
  public List<Event> events;

  @JsonProperty("tasks")
  public List<Task> tasks;

  @JsonProperty("max-events")
  public int maxEvents;

  @JsonProperty("max-tasks")
  public int maxTasks;

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

  //constructor used in testing
  public Day() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
    this.maxEvents = 0;
    this.maxTasks = 0;
  }

  public void addEvent(Event event) {
    events.add(event);
  }

  public void addTasks(Task task) {
    tasks.add(task);
  }
}
