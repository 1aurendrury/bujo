package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.controller.ControllerImpl;
import java.util.ArrayList;
import java.util.List;

public class Day {
  @JsonProperty("events")
  public List<Event> events;

  @JsonProperty("tasks")
  public List<Task> tasks;

  public Day (
      @JsonProperty("events") List<Event> events,
      @JsonProperty("tasks") List<Task> tasks,
      @JsonProperty("max-events") int maxEvents,
      @JsonProperty("max-tasks") int maxTasks) {
    this.events = events;
    this.tasks = tasks;
  }

  //constructor used in testing
  public Day() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  public void addEvent(Event event, int maxEvents) {
    if (this.events.size() >= maxEvents) {
      ControllerImpl.handleWarning("Maximum number of events per day reached!");
    } else {
      events.add(event);
    }
  }

  public void addTasks(Task task, int maxTasks) {
    if (this.tasks.size() >= maxTasks) {
      ControllerImpl.handleWarning("Maximum number of tasks per day reached!");
    } else {
      tasks.add(task);
    }
  }
}
