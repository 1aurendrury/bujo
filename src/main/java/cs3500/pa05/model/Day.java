package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

public class Day {
  String name;
  List<Event> events;
  List<Task> tasks;
  int maxEvents;
  int maxTasks;

  public Day (String name, List<Event> events, List<Task> tasks, int maxEvents, int maxTasks) {
    this.name = name;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
    this.maxEvents = maxEvents;
    this.maxTasks = maxTasks;
  }
}
