package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
  @JsonProperty("name")
  private String name;

  @JsonProperty("desc")
  private String desc;

  @JsonProperty("day")
  private String day;

  @JsonProperty("is-complete")
  private boolean isComplete;

  public Task(@JsonProperty("name") String name,
              @JsonProperty("desc") String desc,
              @JsonProperty("day") String day,
              @JsonProperty("is-complete") boolean isComplete) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    this.isComplete = isComplete;
  }
}
