package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Day {
  String name;
  List<Event> events;
  List<Task> tasks;
  int maxEvents;
  int maxTasks;

  public Day (String name, @JsonProperty("events") List<Event> events,
              @JsonProperty("tasks") List<Task> tasks,
              @JsonProperty("max-events") int maxEvents,
              @JsonProperty("max-tasks") int maxTasks) {
    this.name = name;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
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
