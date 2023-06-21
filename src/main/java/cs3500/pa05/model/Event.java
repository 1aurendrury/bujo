package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
  String name;
  String desc;
  String day;
  int startTime; //between 1 and 24
  double duration;

  @JsonCreator
  public Event(@JsonProperty("name") String name,
               @JsonProperty("desc") String desc,
               @JsonProperty("day") String day,
               @JsonProperty("startTime") int startTime,
               @JsonProperty("duration") double duration) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    if (startTime >= 1 && startTime <= 24) {
      this.startTime = startTime;
    } else {
      throw new IllegalArgumentException("Start time must be between 1 and 24, inclusive.");
    }
    this.duration = duration;
  }
}
