package cs3500.pa05.model;

public class Task {
  String name;
  String desc;
  String day;
  boolean isComplete;

  public Task(String name, String desc, String day, boolean isComplete) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    this.isComplete = false;
  }
}
