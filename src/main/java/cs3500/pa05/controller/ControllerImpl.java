package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.records.FileJSON;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;

public class ControllerImpl implements Controller {
  private FileJSON file;
  private Button save;
  private Button openFile;
  private List<Task> taskQueue;
  private Menu currentTheme;
  private HBox controls;
  private String path;

  public ControllerImpl(List<Day> days, List<Task> taskQueue, FileJSON file, String path) {
    this.file = file;
    this.taskQueue = taskQueue;
    this.currentTheme = new Menu("Choose the theme");
    this.path = path;
  }

  @Override
  public void run() {
    initButtons();
  }

  private void initButtons() {
    save = new Button("Save");
    save.setPrefWidth(50);
    save.setPrefHeight(25);
    save.setOnAction(e -> handleSave(path));

    openFile = new Button("Open");
    openFile.setPrefWidth(50);
    openFile.setPrefHeight(25);
    openFile.setOnAction(e -> handleOpenFile(path));

    controls.getChildren().addAll(save, openFile);
  }

  void handleSave(String path) {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      Object filePath;
      File outputFile = new File(path);
      objectMapper.writeValue(outputFile, file);
      System.out.println("File saved successfully.");
    } catch (IOException e) {
      System.err.println("Unable to save the file.");
    }
  }

  void handleOpenFile(String path) {
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      File inputFile = new File(path);
      FileJSON fileJSON = objectMapper.readValue(inputFile, FileJSON.class);
      System.out.println("File opened successfully.");

      this.file = fileJSON;

    } catch (IOException e) {
      System.err.println("Unable to open the file.");
    }
  }

  void handleNewTask() {
    TextInputDialog nameDialog = new TextInputDialog();
    nameDialog.setTitle("New Task");
    nameDialog.setHeaderText("Enter task name:");
    nameDialog.setContentText("Name:");
    Optional<String> nameResult = nameDialog.showAndWait();

    if (nameResult.isPresent()) {
      String name = nameResult.get();

      TextInputDialog descDialog = new TextInputDialog();
      descDialog.setTitle("New Task");
      descDialog.setHeaderText("Enter task description:");
      descDialog.setContentText("Description:");
      Optional<String> descResult = descDialog.showAndWait();

      if (descResult.isPresent()) {
        String desc = descResult.get();

        TextInputDialog dayDialog = new TextInputDialog();
        dayDialog.setTitle("New Task");
        dayDialog.setHeaderText("Enter task day:");
        dayDialog.setContentText("Day:");
        Optional<String> dayResult = dayDialog.showAndWait();

        if (dayResult.isPresent()) {
          String day = dayResult.get();

          Alert completeAlert = new Alert(Alert.AlertType.CONFIRMATION);
          completeAlert.setTitle("New Task");
          completeAlert.setHeaderText("Is the task complete?");
          completeAlert.setContentText("Choose an option:");
          ButtonType completeButton = new ButtonType("Complete");
          ButtonType incompleteButton = new ButtonType("Incomplete");
          completeAlert.getButtonTypes().setAll(completeButton, incompleteButton);
          Optional<ButtonType> completeResult = completeAlert.showAndWait();

          boolean isComplete = completeResult.isPresent()
              && completeResult.get() == completeButton;

          Task newTask = new Task(name, desc, day, isComplete);

          taskQueue.add(newTask);
        }
      }
    }
  }

  void handleNewEvent() {
    TextInputDialog nameDialog = new TextInputDialog();
    nameDialog.setTitle("New Event");
    nameDialog.setHeaderText("Enter event name:");
    nameDialog.setContentText("Name:");
    Optional<String> nameResult = nameDialog.showAndWait();

    if (nameResult.isPresent()) {
      String name = nameResult.get();

      TextInputDialog descDialog = new TextInputDialog();
      descDialog.setTitle("New Event");
      descDialog.setHeaderText("Enter event description:");
      descDialog.setContentText("Description:");
      Optional<String> descResult = descDialog.showAndWait();

      if (descResult.isPresent()) {
        String desc = descResult.get();

        TextInputDialog dayDialog = new TextInputDialog();
        dayDialog.setTitle("New Event");
        dayDialog.setHeaderText("Enter event day:");
        dayDialog.setContentText("Day:");
        Optional<String> dayResult = dayDialog.showAndWait();

        if (dayResult.isPresent()) {
          String day = dayResult.get();

          TextInputDialog startTimeDialog = new TextInputDialog();
          startTimeDialog.setTitle("New Event");
          startTimeDialog.setHeaderText("Enter event start time:");
          startTimeDialog.setContentText("Start Time:");
          Optional<String> startTimeResult = startTimeDialog.showAndWait();

          if (startTimeResult.isPresent()) {
            int startTime = Integer.parseInt(startTimeResult.get());

            TextInputDialog durationDialog = new TextInputDialog();
            durationDialog.setTitle("New Event");
            durationDialog.setHeaderText("Enter event duration:");
            durationDialog.setContentText("Duration:");
            Optional<String> durationResult = durationDialog.showAndWait();

            if (durationResult.isPresent()) {
              double duration = Double.parseDouble(durationResult.get());

              Day currentDay = file.days().get(file.days().size()-1);

              if (currentDay != null) {
                Event newEvent = new Event(name, desc, day, startTime, duration);

                currentDay.addEvent(newEvent);
              }
            }
          }
        }
      }
    }
  }


  void handleMaxTasksEvents() {

  }

  void handleThemeChange(String theme) {

  }

  void handleWarning() {

  }
}