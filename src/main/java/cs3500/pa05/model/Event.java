package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an event
 */
public class Event {
  public String name;
  public String desc;
  public String day;
  public int startTime; //between 1 and 24
  public double duration;

  /**
   * Constructor for the event
   *
   * @param name name of the event
   * @param desc description of the event
   * @param day day of the event
   * @param startTime start time of the event (hours)
   * @param duration duration of the event (hours)
   */
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

  /**
   * Returns the day of the event
   *
   * @return day of the event
   */
  public String getDay() {
    return this.day;
  }

  /**
   * Converts the event to a string
   *
   * @return event representation
   */
  public String toString() {
    int endHour = startTime + (int) duration;
    int endMinute = (int) (duration % 1 * 60);
    return name + " (" + startTime + ":00 - " + endHour
        + ":" + String.format("%02d", endMinute) + ")" + "\n" + desc + "\n";
  }

  /**
   * Returns the URL in the description of an event
   *
   * @return url of the event
   */
  public String getUrl() {
    String url;
    if (desc.contains("https://") || desc.contains("http://")) {
      int urlStart = desc.indexOf("http");
      int urlEnd = desc.indexOf(".") + 4;
      url = desc.substring(urlStart, urlEnd);
    } else {
      url = "";
    }
    return url;
  }
}
