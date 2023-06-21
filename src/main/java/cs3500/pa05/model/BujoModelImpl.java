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
  public void addTask(Task task) {
    this.allTasks.add(task);
  }

  /**
   * Adds an event to this BujoModel's list of events
   * @param event the event to be added to this BujoModel, as an event
   */
  @Override
  public void addEvent(Event event) {
    this.allEvents.add(event);
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
}
