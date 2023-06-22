package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.BujoFile;
import cs3500.pa05.model.BujoModelImpl;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.view.BujoSceneImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerImpl implements Controller {
  @FXML
  private Stage stage;
  private BujoFile bujoFile;
  private List<Task> taskQueue;
  private String theme;
  @FXML
  private Button settings;
  private String path;
  private BujoModelImpl bujoModel;

  // initialize all of the buttons
  @FXML
  private Scene lightmode;
  @FXML
  private AnchorPane entireScreen;
  @FXML
  private VBox sundayBox;
  @FXML
  private VBox mondayBox;
  @FXML
  private VBox tuesdayBox;
  @FXML
  private VBox wednesdayBox;
  @FXML
  private VBox thursdayBox;
  @FXML
  private VBox fridayBox;
  @FXML
  private VBox saturdayBox;
  @FXML
  private HBox statsBox;
  @FXML
  private HBox tasksBox;
  @FXML
  private VBox tasksQueue;

  @FXML
  private Label sundayLabel1;

  @FXML
  private AnchorPane sundayTasks;
  @FXML
  private ListView sundayTaskView;
  @FXML
  private AnchorPane sundayEvents;
  @FXML
  private ListView sundayEventView;
  @FXML
  private Label mondayLabel;
  @FXML
  private AnchorPane mondayTasks;
  @FXML
  private ListView mondayTaskView;
  @FXML
  private AnchorPane mondayEvents;
  @FXML
  private ListView mondayEventView;
  @FXML
  private Label tuesdayLabel;
  @FXML
  private AnchorPane tuesdayTasks;
  @FXML
  private ListView tuesdayTaskView;
  @FXML
  private AnchorPane tuesdayEvents;
  @FXML
  private ListView tuesdayEventView;
  @FXML
  private Label wednesdayLabel;
  @FXML
  private AnchorPane wednesdayTasks;
  @FXML
  private ListView wednesdayTaskView;
  @FXML
  private AnchorPane wednesdayEvents;
  @FXML
  private ListView wednesdayEventView;
  @FXML
  private Label thursdayLabel;
  @FXML
  private AnchorPane thursdayTasks;
  @FXML
  private ListView thursdayTaskView;
  @FXML
  private AnchorPane thursdayEvents;
  @FXML
  private ListView thursdayEventView;
  @FXML
  private Label fridayLabel;
  @FXML
  private AnchorPane fridayTasks;
  @FXML
  private ListView fridayTaskView;
  @FXML
  private AnchorPane fridayEvents;
  @FXML
  private ListView fridayEventView;
  @FXML
  private Label saturdayLabel;
  @FXML
  private AnchorPane saturdayTasks;
  @FXML
  private ListView saturdayTaskView;
  @FXML
  private AnchorPane saturdayEvents;
  @FXML
  private ListView saturdayEventView;
  @FXML
  private Button saveFile;
  @FXML
  private Button openFile;
  @FXML
  private ChoiceBox<String> chooseTheme;
  @FXML
  private Label tasksLabel;
  @FXML
  private AnchorPane tasksQueueBox;
  @FXML
  private ListView tasksQueueView;
  @FXML
  private ProgressBar taskProgressBar;
  @FXML
  private Label quotesNotesLabel;
  @FXML
  private AnchorPane quotesNotesBox;
  @FXML
  private TextField quoteBox;
  @FXML
  private Label statsLabel;
  @FXML
  private AnchorPane statsAP;
  @FXML
  private Label weekStatsBox;
  @FXML
  private Button addEvent;
  @FXML
  private Button addTask;
  @FXML
  private List<String> tasks;
  @FXML
  private List<String> events;
  private String filePath;

  @FXML
  private ImageView currentBG;

  @FXML
  private ArrayList<Label> allText;



  // things we need (as of now)
  /*
    - implement chooseTheme for themes (i can do this - lauren)
    - implement the quotes/notes text box
    - implement settings to choose max tasks and events
    - weekly stats box

   */


  public ControllerImpl(Stage stage, List<Task> taskQueue, BujoFile bujoFile, String path,
                        BujoModelImpl bujoModel) {
    this.tasks = new ArrayList<>();
    this.events = new ArrayList<>();
    this.stage = stage;
    this.bujoFile = bujoFile;
    this.taskQueue = taskQueue;
    this.path = path;
    this.bujoModel = bujoModel;
    this.allText = new ArrayList<Label>();

  }

  @Override
  public void run() {
    initButtons();
  }

  private void initButtons() {
    saveFile.setOnAction(e -> handleSave());

    openFile.setOnAction(e -> handleOpenFile());

    addEvent.setOnAction(e -> handleNewEvent());

    addTask.setOnAction(e -> handleNewTask());

    settings.setOnAction(e -> handleSettings());

    chooseTheme.getItems().addAll("Light Theme", "Dark Theme", "NEU Theme");
    chooseTheme.setValue("Light Theme");
    chooseTheme.setOnAction(e -> handleThemeChange(chooseTheme.getValue()));

  }

  void handleSave() {
    ObjectMapper objectMapper = new ObjectMapper();

    if (filePath == null) {
      DirectoryChooser directoryChooser = new DirectoryChooser();
      File selectedDirectory = directoryChooser.showDialog(this.stage);

      if (selectedDirectory != null) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Save File");
        dialog.setHeaderText("Enter the name for your journal");
        dialog.setContentText("File Name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
          String fileName = result.get();
          String filePath = selectedDirectory.getPath() + "/" + fileName + ".bujo";
          File file = new File(filePath);

          try {
            objectMapper.writeValue(file, this.bujoModel);
            System.out.println("Saved successfully.");
          } catch (IOException e) {
            System.out.println("Failed to save the file: " + e.getMessage());
          }
        }
      }
    } else {
      try {
        File file = new File(filePath);
        objectMapper.writeValue(file, this.bujoModel);
        System.out.println("Saved successfully.");
      } catch (IOException e) {
        System.out.println("Failed to save the file: " + e.getMessage());
      }
    }
  }

  void handleOpenFile() {
    ObjectMapper objectMapper = new ObjectMapper();

    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BUJO Files", "*.bujo"));

    File selectedFile = fileChooser.showOpenDialog(this.stage);

    if (selectedFile != null) {
      try {
        this.bujoModel = objectMapper.readValue(selectedFile, BujoModelImpl.class);
        for (Task t : bujoModel.getTasks()) {
          tasks.add(t.name);
        }
        filePath = selectedFile.getPath();
      } catch (IOException e) {
        System.err.println("Failed to open the file: " + e.getMessage());
      }
    } else {
      System.err.println("No file chosen.");
    }

    displayTasks();
    displayEvents();
  }

  void handleNewTask() {
    TextInputDialog nameDialog = new TextInputDialog();
    nameDialog.setTitle("New Task");
    nameDialog.setHeaderText("Enter task name: ");
    nameDialog.setContentText("Name: ");
    Optional<String> nameResult = nameDialog.showAndWait();

    if (nameResult.isPresent()) {
      String name = nameResult.get();

      TextInputDialog descDialog = new TextInputDialog();
      descDialog.setTitle("New Task");
      descDialog.setHeaderText("Enter task description: ");
      descDialog.setContentText("Description: ");
      Optional<String> descResult = descDialog.showAndWait();

      if (descResult.isPresent()) {
        String desc = descResult.get();

        TextInputDialog dayDialog = new TextInputDialog();
        dayDialog.setTitle("New Task");
        dayDialog.setHeaderText("Enter task day: ");
        dayDialog.setContentText("Day: ");
        Optional<String> dayResult = dayDialog.showAndWait();

        if (dayResult.isPresent()) {
          String day = dayResult.get();

          Alert completeAlert = new Alert(Alert.AlertType.CONFIRMATION);
          completeAlert.setTitle("New Task");
          completeAlert.setHeaderText("Is the task complete?");
          completeAlert.setContentText("Choose an option: ");
          ButtonType completeButton = new ButtonType("Complete");
          ButtonType incompleteButton = new ButtonType("Incomplete");
          completeAlert.getButtonTypes().setAll(completeButton, incompleteButton);
          Optional<ButtonType> completeResult = completeAlert.showAndWait();

          boolean isComplete = completeResult.isPresent()
              && completeResult.get() == completeButton;

          Task newTask = new Task(name, desc, day, isComplete);

          tasks.add(name);
          bujoModel.addTask(newTask, day);
          displayTasks();
        }
      }
    }
  }

  void displayTasks() {
    if (tasks.size() > 0) {
      tasksQueueView.getItems().add(tasks.get(tasks.size() - 1));
      Task t = bujoModel.getTasks().get(bujoModel.getTasks().size() - 1);
      switch (t.getDay().toLowerCase()) {
        case "sunday" -> sundayTaskView.getItems().add(t.toString());
        case "monday" -> mondayTaskView.getItems().add(t.toString());
        case "tuesday" -> tuesdayTaskView.getItems().add(t.toString());
        case "wednesday" -> wednesdayTaskView.getItems().add(t.toString());
        case "thursday" -> thursdayTaskView.getItems().add(t.toString());
        case "friday" -> fridayTaskView.getItems().add(t.toString());
        case "saturday" -> saturdayTaskView.getItems().add(t.toString());
        default -> {
          throw new IllegalArgumentException("Day entered is invalid");
        }
      }
    }
  }

  void displayEvents() {
    if (bujoModel.getEvents().size() > 0) {
      Event e = bujoModel.getEvents().get(bujoModel.getEvents().size() - 1);
      switch (e.getDay().toLowerCase()) {
        case "sunday" -> sundayEventView.getItems().add(e.toString());
        case "monday" -> mondayEventView.getItems().add(e.toString());
        case "tuesday" -> tuesdayEventView.getItems().add(e.toString());
        case "wednesday" -> wednesdayEventView.getItems().add(e.toString());
        case "thursday" -> thursdayEventView.getItems().add(e.toString());
        case "friday" -> fridayEventView.getItems().add(e.toString());
        case "saturday" -> saturdayEventView.getItems().add(e.toString());
        default -> {
          throw new IllegalArgumentException("Day entered is invalid");
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
              Event newEvent = new Event(name, desc, day, startTime, duration);

              events.add(name);
              bujoModel.addEvent(newEvent, day);
              displayEvents();
            }
          }
        }
      }
    }
  }

  void handleSettings() {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Settings");
    dialog.setHeaderText("Set maximum number of tasks and events per day:");

    Label maxTasksLabel = new Label("Maximum Tasks:");
    Label maxEventsLabel = new Label("Maximum Events:");
    TextField maxTasksTextField = new TextField();
    TextField maxEventsTextField = new TextField();

    GridPane grid = new GridPane();
    grid.add(maxTasksLabel, 0, 0);
    grid.add(maxTasksTextField, 1, 0);
    grid.add(maxEventsLabel, 0, 1);
    grid.add(maxEventsTextField, 1, 1);
    dialog.getDialogPane().setContent(grid);

    ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);

    dialog.setResultConverter(buttonType -> {
      if (buttonType == okButton) {
        String maxTasksText = maxTasksTextField.getText();
        String maxEventsText = maxEventsTextField.getText();

        int maxTasks = Integer.parseInt(maxTasksText);
        int maxEvents = Integer.parseInt(maxEventsText);

        handleMaxTasksEvents(maxTasks, maxEvents);
        saveMaxTasksEvents(maxTasks, maxEvents);
      }
      return null;
    });

    dialog.showAndWait();
  }

  private void handleMaxTasksEvents(int maxTasks, int maxEvents) {
    bujoModel.setMaxTasksPerDay(maxTasks);
    bujoModel.setMaxEventsPerDay(maxEvents);
  }

  private void saveMaxTasksEvents(int maxTasks, int maxEvents) {
    bujoModel.setMaxTasksPerDay(maxTasks);
    bujoModel.setMaxEventsPerDay(maxEvents);
  }

  void handleThemeChange(String theme) {
    this.theme = theme;
    allText.addAll(Arrays.asList(sundayLabel1, mondayLabel, tuesdayLabel,
        wednesdayLabel, thursdayLabel, fridayLabel, saturdayLabel, tasksLabel,
        quotesNotesLabel, statsLabel, weekStatsBox));
    if (theme.equals("Light Theme")) {
      currentBG = new ImageView("/src/main/resources/whitebg.jpg");
      for (Label l: allText) {
        l.setFont(Font.font("Rockwell"));
      }
      for (Label l: allText) {
        l.setStyle("-fx-text-fill: black");
      }
    }
    else if (theme.equals("Dark Theme")) {
      currentBG = new ImageView("/src/main/resources/dbg.jpg");
      for (Label l: allText) {
        l.setStyle("-fx-text-fill: white");
      }
      for (Label l: allText) {
        l.setFont(Font.font("Arial"));
      }
    }
    else {
      currentBG = new ImageView("/src/main/resources/neubg.jpg");
      for (Label l: allText) {
        l.setStyle("-fx-text-fill: red");
      }
      for (Label l: allText) {
        l.setFont(Font.font("Eras Bold Itc"));
      }
    }
    handleSave();
  }

  public static void handleWarning(String message) {
    Alert warningAlert = new Alert(Alert.AlertType.WARNING);
    warningAlert.setTitle("Warning");
    warningAlert.setContentText(message);
    warningAlert.showAndWait();
  }
}