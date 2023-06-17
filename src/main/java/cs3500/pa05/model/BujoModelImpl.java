package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

public class BujoModelImpl implements BujoModel {
  List<Day> days;
  List<Event> allEvents;
  List<Task> allTasks;

  public BujoModelImpl() {
    this.days = new ArrayList<>();
    this.allEvents = new ArrayList<>();
    this.allTasks = new ArrayList<>();
  }

  public BujoModelImpl(List<Day> days, List<Event> allEvents, List<Task> allTasks) {
    this.days = days;
    this.allEvents = allEvents;
    this.allTasks = allTasks;
  }

  @Override
  public void changeTheme() {

  }

  @Override
  public void addTask(Task task) {
    this.allTasks.add(task);
  }

  @Override
  public void addEvent(Event event) {
    this.allEvents.add(event);
  }

  public void createDays() {

  }

  public List<Task> getTasks() {
    return this.allTasks;
  }
}
