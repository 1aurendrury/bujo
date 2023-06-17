package cs3500.pa05;

import cs3500.pa05.controller.ControllerImpl;
import cs3500.pa05.model.BujoModelImpl;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.records.FileJSON;
import cs3500.pa05.view.BujoSceneImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;

public class Driver  {

  // class has to extend Application, will add this once everything is implemented

//  public void start(Stage stage) {
//    stage.setTitle("PA05 Bullet Journal");
//
//    List<Day> days = new ArrayList<>();
//    List<Task> taskQueue = new ArrayList<>();
//    FileJSON file = new FileJSON("lightmode.fxml", "light mode", days);
//
//    BujoModelImpl model = new BujoModelImpl();
//    ControllerImpl controller = new ControllerImpl(
//        days, taskQueue, file, "/src/main/resources/lightmode.fxml");
//
//    BujoSceneImpl view = new BujoSceneImpl(controller);
//
//    try {
//      stage.setScene(view.load());
//
//      controller.run();
//
//      stage.show();
//    }
//    catch (IllegalStateException e) {
//      System.err.println("Unable to load bullet journal");
//    }
// }
//
// public static void main(String[] args) {
//    launch();
// }


}

