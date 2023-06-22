package cs3500.pa05.model;

/**
 * Interface for a BujoModel
 */
public interface BujoModel {
  /**
   * Changes the theme of a BujoModel
   *
   * @param theme the new theme for this BujoModel, as a Theme datatype
   */
  void changeTheme(Theme theme);

  /**
   * Adds a task to this BujoModel's list of tasks
   *
   * @param task the task to be added to this BujoModel, as a Task
   */
  void addTask(Task task, String day);

  /**
   * Adds an event to this BujoModel's list of events
   *
   * @param event the event to be added to this BujoModel, as an event
   */
  void addEvent(Event event, String day);
}
