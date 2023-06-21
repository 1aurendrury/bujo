package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an instance of a BujoModel
 */
public class BujoModelImpl implements BujoModel {
  List<Day> days;
  List<Event> allEvents;
  List<Task> allTasks;
  Theme theme;

  public BujoModelImpl() {
    this.days = new ArrayList<>();
    createDays();
    this.allEvents = new ArrayList<>();
    this.allTasks = new ArrayList<>();
    this.theme = null;
  }

  /**
   * Changes the theme of a BujoModel
   * @param theme the new theme for this BujoModel, as a Theme datatype
   */
  @Override
  public void changeTheme(Theme theme) {
    this.theme = theme;
  }

  /**
   * Adds a task to this BujoModel's list of tasks
   * @param task the task to be added to this BujoModel, as a Task
   */
  @Override
  public void addTask(Task task, String day) {
    this.allTasks.add(task);
    switch (day.toLowerCase()) {
      case "sunday" -> days.get(0).tasks.add(task);
      case "monday" -> days.get(1).tasks.add(task);
      case "tuesday" -> days.get(2).tasks.add(task);
      case "wednesday" -> days.get(3).tasks.add(task);
      case "thursday" -> days.get(4).tasks.add(task);
      case "friday" -> days.get(5).tasks.add(task);
      case "saturday" -> days.get(6).tasks.add(task);
      default ->  {
        throw new IllegalArgumentException("Day entered is invalid");
      }
    }
  }

  /**
   * Adds an event to this BujoModel's list of events
   * @param event the event to be added to this BujoModel, as an event
   */
  @Override
  public void addEvent(Event event, String day) {
    this.allEvents.add(event);
    switch (day.toLowerCase()) {
      case "sunday" -> days.get(0).events.add(event);
      case "monday" -> days.get(1).events.add(event);
      case "tuesday" -> days.get(2).events.add(event);
      case "wednesday" -> days.get(3).events.add(event);
      case "thursday" -> days.get(4).events.add(event);
      case "friday" -> days.get(5).events.add(event);
      case "saturday" -> days.get(6).events.add(event);
      default ->  {
        throw new IllegalArgumentException("Day entered is invalid");
      }
    }
  }

  /**
   * Generates a week's worth of days, starting with Sunday. Maximum events and tasks are set to 1
   */
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

  /**
   * Provides the tasks from a BujoModelImpl
   * @return the list of tasks attatched to this BujoModelImpl
   */
  public List<Task> getTasks() {
    return this.allTasks;
  }

  /**
   * Provides the events from a BujoModelImpl
   * @return the list of events attatched to this BujoModelImpl
   */
  public List<Event> getEvents() {
    return this.allEvents;
  }
}
