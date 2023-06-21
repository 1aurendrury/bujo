package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
  @JsonProperty("name")
  public String name;

  @JsonProperty("desc")
  public String desc;

  @JsonProperty("day")
  public String day;

  @JsonProperty("is-complete")
  public boolean isComplete;

  public Task(@JsonProperty("name") String name,
              @JsonProperty("desc") String desc,
              @JsonProperty("day") String day,
              @JsonProperty("is-complete") boolean isComplete) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    this.isComplete = isComplete;
  }

  public String getDay() {
    return this.day;
  }

  public String toString() {
    String complete;
    if (isComplete) {
      complete = "Complete";
    } else {
      complete = "Not complete";
    }
    return name + "\n" + desc + "\n" + complete;
  }
}
