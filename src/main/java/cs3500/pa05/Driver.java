package cs3500.pa05;

import cs3500.pa05.controller.ControllerImpl;
import cs3500.pa05.model.BujoFile;
import cs3500.pa05.model.BujoModelImpl;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import cs3500.pa05.view.BujoSceneImpl;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents the driver class
 */
public class Driver extends Application {

  // class has to extend Application, will add this once everything is implemented

  /**
   * Starts the application
   *
   * @param stage the primary stage for this application, onto which
   *              the application scene can be set.
   *              Applications may create other stages, if needed, but they will not be
   *              primary stages.
   */
  public void start(Stage stage) {
    stage.setTitle("PA05 Bullet Journal");

    List<Day> days = new ArrayList<>();
    List<Task> taskQueue = new ArrayList<>();
    BujoFile file = new BujoFile("lightmode.fxml", "Light Theme", days);

    BujoModelImpl model = new BujoModelImpl();
    ControllerImpl controller = new ControllerImpl(stage,
        taskQueue, file, "/src/main/resources/lightmode.fxml", new BujoModelImpl());

    BujoSceneImpl view = new BujoSceneImpl(controller);

    try {
      stage.setScene(view.load());

      controller.run();

      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load bullet journal");
    }
  }

  /**
   * Entry point to the program
   *
   * @param args no args required
   */
  public static void main(String[] args) {
    launch();
  }
}