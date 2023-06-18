package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BujoFile {
  @JsonProperty("theme")
  private String theme;

  @JsonProperty("name")
  private String name;

  @JsonProperty("days")
  public List<Day> days;

  @JsonProperty("max-tasks")
  private int maxTasks;

  @JsonProperty("max-events")
  private int maxEvents;

  public BujoFile(
      @JsonProperty("theme") String theme,
      @JsonProperty("name") String name,
      @JsonProperty("days") List<Day> days,
      @JsonProperty("max-tasks") int maxTasks,
      @JsonProperty("max-events") int maxEvents) {
    this.theme = theme;
    this.name = name;
    this.days = days;
    this.maxTasks = maxTasks;
    this.maxEvents = maxEvents;
  }

  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }

  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }
}
