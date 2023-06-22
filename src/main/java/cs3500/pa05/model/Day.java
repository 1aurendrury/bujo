package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.controller.ControllerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Representss a single day
 */
public class Day {
  @JsonProperty("events")
  public List<Event> events;

  @JsonProperty("tasks")
  public List<Task> tasks;

  /**
   * Represents a day constructor
   *
   * @param events events in a day
   * @param tasks tasks in a day
   */
  public Day(
      @JsonProperty("events") List<Event> events,
      @JsonProperty("tasks") List<Task> tasks) {
    this.events = events;
    this.tasks = tasks;
  }

  /**
   * Constructor used in testing
   */
  public Day() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * Adds an event to the day
   *
   * @param event event
   * @param maxEvents max number of events
   */
  public void addEvent(Event event, int maxEvents) {
    if (this.events.size() >= maxEvents) {
      ControllerImpl.handleWarning("Maximum number of events per day reached!\n"
          + "Add events with caution!");
    } else {
      events.add(event);
    }
  }

  /**
   * Adds a task to the day
   *
   * @param task task
   * @param maxTasks max number of tasks
   */
  public void addTasks(Task task, int maxTasks) {
    if (this.tasks.size() >= maxTasks) {
      ControllerImpl.handleWarning("Maximum number of tasks per day reached!\n"
          + "Add tasks with caution!");
    } else {
      tasks.add(task);
    }
  }
}
