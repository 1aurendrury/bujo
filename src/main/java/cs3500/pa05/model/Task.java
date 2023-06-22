package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task
 */
public class Task {
  @JsonProperty("name")
  public String name;

  @JsonProperty("desc")
  public String desc;

  @JsonProperty("day")
  public String day;

  @JsonProperty("is-complete")
  public boolean isComplete;

  /**
   * Task constructor
   *
   * @param name name of the task
   * @param desc description of the tast
   * @param day day of the task
   * @param isComplete complete?
   */
  public Task(@JsonProperty("name") String name,
              @JsonProperty("desc") String desc,
              @JsonProperty("day") String day,
              @JsonProperty("is-complete") boolean isComplete) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    this.isComplete = isComplete;
  }

  /**
   * Returns the day of the task
   *
   * @return day of the task
   */
  public String getDay() {
    return this.day;
  }

  /**
   * Converts the task to a string
   *
   * @return task representation
   */
  public String toString() {
    String complete;
    if (isComplete) {
      complete = "Complete";
    } else {
      complete = "Not complete";
    }
    return name + "\n" + desc + "\n" + complete;
  }

  /**
   * Returns the URL in the description of a task
   *
   * @return url of the task
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
