package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerImpl;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class BujoSceneImpl implements BujoView {

  private final FXMLLoader loader;

  public BujoSceneImpl(ControllerImpl controller) {
    this.loader = new FXMLLoader();
    // light mode will be the standard setting, themes can be changed once bujo is opened
    this.loader.setLocation(getClass().getClassLoader().getResource("lightmode.fxml"));
    this.loader.setController(controller);
  }

  @Override
  public Scene load() {
    try {
      return this.loader.load();
    }
    catch (IOException e) {
      throw new IllegalStateException("Unable to load bullet journal");
    }
  }
}
