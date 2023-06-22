package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a Bujo file with Json elements as the fields
 */
public class BujoFile {
  @JsonProperty("theme")
  String theme;

  @JsonProperty("name")
  private String name;

  @JsonProperty("days")
  public List<Day> days;

  @JsonProperty("max-tasks")
  int maxTasks;

  @JsonProperty("max-events")
  int maxEvents;

  /**
   * Represents an instance of a BujoFile with max tasks and events initialized to 0
   *
   * @param theme the theme of the file as a string
   * @param name the name of the file as a string
   * @param days the days in this file
   */
  public BujoFile(
      @JsonProperty("theme") String theme,
      @JsonProperty("name") String name,
      @JsonProperty("days") List<Day> days) {
    this.theme = theme;
    this.name = name;
    this.days = days;
    this.maxTasks = 0;
    this.maxEvents = 0;
  }

  /**
   * Changes the max tasks of the Bujo file to the supplied int
   *
   * @param maxTasks the new number of maximum tasks that will be allowed in the file, as an int
   */
  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }

  /**
   * Changes the max events of the Bujo file to the supplied int
   *
   * @param maxEvents the new number of maximum tasks that will be allowed in the file, as an int
   */
  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  /**
   * Applies the supplied string to this Bujo file
   *
   * @param theme the new theme of this Bujo file, as a string
   */
  public void setTheme(String theme) {
    this.theme = theme;
  }
}
