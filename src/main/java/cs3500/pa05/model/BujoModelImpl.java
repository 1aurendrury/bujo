package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

public class BujoModelImpl implements BujoModel {
  List<Day> days;
  List<Event> allEvents;
  List<Task> allTasks;
  Theme theme;

  public BujoModelImpl() {
    this.days = new ArrayList<>();
    this.allEvents = new ArrayList<>();
    this.allTasks = new ArrayList<>();
    this.theme = null;
  }

  public BujoModelImpl(List<Day> days, List<Event> allEvents, List<Task> allTasks, Theme theme) {
    this.days = days;
    this.allEvents = allEvents;
    this.allTasks = allTasks;
    this.theme = theme;
  }

  @Override
  public void changeTheme(Theme theme) {
    this.theme = theme;
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
    List<Day> days = new ArrayList<>();
    Day sunday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);
    Day monday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);
    Day tuesday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);
    Day wednesday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);
    Day thursday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);
    Day friday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);
    Day saturday = new Day(new ArrayList<>(), new ArrayList<>(), 1, 1);

    days.add(sunday);
    days.add(monday);
    days.add(tuesday);
    days.add(wednesday);
    days.add(thursday);
    days.add(friday);
    days.add(saturday);

    this.days = days;
  }

  public List<Task> getTasks() {
    return this.allTasks;
  }
}
