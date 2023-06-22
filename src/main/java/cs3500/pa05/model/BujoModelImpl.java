package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an instance of a BujoModel
 */
public class BujoModelImpl implements BujoModel {
  public List<Day> days;
  public List<Event> allEvents;
  public List<Task> allTasks;
  public Theme theme;
  public int maxEventsPerDay;
  public int maxTasksPerDay;


  /**
   * Constructor for the model implementation
   */
  public BujoModelImpl() {
    this.days = new ArrayList<>();
    this.allEvents = new ArrayList<>();
    this.allTasks = new ArrayList<>();
    this.theme = null;
    this.maxEventsPerDay = 100;
    this.maxTasksPerDay = 100;
    createDays();
  }

  /**
   * Changes the theme of a BujoModel
   *
   * @param theme the new theme for this BujoModel, as a Theme datatype
   */
  @Override
  public void changeTheme(Theme theme) {
    this.theme = theme;
  }

  /**
   * Adds a task to this BujoModel's list of tasks
   *
   * @param task the task to be added to this BujoModel, as a Task
   */
  @Override
  public void addTask(Task task, String day) {
    this.allTasks.add(task);
    switch (day.toLowerCase()) {
      case "sunday" -> days.get(0).addTasks(task, maxTasksPerDay);
      case "monday" -> days.get(1).addTasks(task, maxTasksPerDay);
      case "tuesday" -> days.get(2).addTasks(task, maxTasksPerDay);
      case "wednesday" -> days.get(3).addTasks(task, maxTasksPerDay);
      case "thursday" -> days.get(4).addTasks(task, maxTasksPerDay);
      case "friday" -> days.get(5).addTasks(task, maxTasksPerDay);
      case "saturday" -> days.get(6).addTasks(task, maxTasksPerDay);
      default ->  {
        throw new IllegalArgumentException("Day entered is invalid");
      }
    }
  }

  /**
   * Adds an event to this BujoModel's list of events
   *
   * @param event the event to be added to this BujoModel, as an event
   */
  @Override
  public void addEvent(Event event, String day) {
    this.allEvents.add(event);
    switch (day.toLowerCase()) {
      case "sunday" -> days.get(0).addEvent(event, maxEventsPerDay);
      case "monday" -> days.get(1).addEvent(event, maxEventsPerDay);
      case "tuesday" -> days.get(2).addEvent(event, maxEventsPerDay);
      case "wednesday" -> days.get(3).addEvent(event, maxEventsPerDay);
      case "thursday" -> days.get(4).addEvent(event, maxEventsPerDay);
      case "friday" -> days.get(5).addEvent(event, maxEventsPerDay);
      case "saturday" -> days.get(6).addEvent(event, maxEventsPerDay);
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
    Day sunday = new Day(new ArrayList<>(), new ArrayList<>());
    Day monday = new Day(new ArrayList<>(), new ArrayList<>());
    Day tuesday = new Day(new ArrayList<>(), new ArrayList<>());
    Day wednesday = new Day(new ArrayList<>(), new ArrayList<>());
    Day thursday = new Day(new ArrayList<>(), new ArrayList<>());
    Day friday = new Day(new ArrayList<>(), new ArrayList<>());
    Day saturday = new Day(new ArrayList<>(), new ArrayList<>());

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
   *
   * @return the list of tasks attatched to this BujoModelImpl
   */
  public List<Task> getTasks() {
    return this.allTasks;
  }

  /**
   * Provides the events from a BujoModelImpl
   *
   * @return the list of events attatched to this BujoModelImpl
   */
  public List<Event> getEvents() {
    return this.allEvents;
  }

  public void setMaxEventsPerDay(int maxEventsPerDay) {
    this.maxEventsPerDay = maxEventsPerDay;
  }

  public void setMaxTasksPerDay(int maxTasksPerDay) {
    this.maxTasksPerDay = maxTasksPerDay;
  }

}
