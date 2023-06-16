package cs3500.pa05.controller;

import java.util.List;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;

public class ControllerImpl implements Controller {
  List<Day> days;
  Button save;
  Button openFile;
  List<Task> taskQueue;
  Menu currentTheme;

  ControllerImpl(List<Day> days, List<Task> taskQueue) {
    this.days = days;
    this.save = new Button("Save");
    this.openFile = new Button("Open");
    this.taskQueue = taskQueue;
    this.currentTheme = new Menu("Choose the theme");
  }

  @Override
  public void run() {

  }

  void handleSave() {

  }

  void handleOpenFile() {

  }

  void handleNewTask() {

  }

  void handleNewEvent() {

  }

  void handleMaxTasksEvents() {

  }

  void handleThemeChange(String theme) {

  }

  void handleWarning() {

  }
}