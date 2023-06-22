package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerImpl;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represents a scene of a week
 */
public class BujoSceneImpl implements BujoView {

  // initalize the loader
  private final FXMLLoader loader;

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
  private Label sundayLabel;
  @FXML
  private AnchorPane sundayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksSun;
  @FXML
  private Button addTaskSun;
  @FXML
  private AnchorPane sundayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsSun;
  @FXML
  private Button addEventSun;
  @FXML
  private Label mondayLabel;
  @FXML
  private AnchorPane mondayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksMon;
  @FXML
  private Button addTaskMon;
  @FXML
  private AnchorPane mondayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsMon;
  @FXML
  private Button addEventMon;
  @FXML
  private Label tuesdayLabel;
  @FXML
  private AnchorPane tuesdayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksTues;
  @FXML
  private Button addTaskTues;
  @FXML
  private AnchorPane tuesdayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsTues;
  @FXML
  private Button addEventTues;
  @FXML
  private Label wednesdayLabel;
  @FXML
  private AnchorPane wednesdayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksWed;
  @FXML
  private Button addTaskWed;
  @FXML
  private AnchorPane wednesdayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsWed;
  @FXML
  private Button addEventWed;
  @FXML
  private Label thursdayLabel;
  @FXML
  private AnchorPane thursdayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksThurs;
  @FXML
  private Button addTaskThurs;
  @FXML
  private AnchorPane thursdayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsThurs;
  @FXML
  private Button addEventThurs;
  @FXML
  private Label fridayLabel;
  @FXML
  private AnchorPane fridayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksFri;
  @FXML
  private Button addTaskFri;
  @FXML
  private AnchorPane fridayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsFri;
  @FXML
  private Button addEventFri;
  @FXML
  private Label saturdayLabel;
  @FXML
  private AnchorPane saturdayTasks;
  @FXML
  private ChoiceBox<Integer> numTasksSat;
  @FXML
  private Button addTaskSat;
  @FXML
  private AnchorPane saturdayEvents;
  @FXML
  private ChoiceBox<Integer> numEventsSat;
  @FXML
  private Button addEventSat;
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
  private AnchorPane statsAp;
  @FXML
  private Label weekStatsBox;

  /**
   * Constructor for the scene implementation
   *
   * @param controller controller implementation
   */
  public BujoSceneImpl(ControllerImpl controller) {
    this.loader = new FXMLLoader();
    // light mode will be the standard setting, themes can be changed once bujo is opened
    this.loader.setLocation(getClass().getClassLoader().getResource("lightmode.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Renders the scene
   *
   * @return scene view
   */
  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to load bullet journal");
    }
  }
}
