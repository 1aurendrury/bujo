package cs3500.pa05.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the event view
 */
public class EventView extends VBox {

  public Label name;
  public Label desc;
  public Label day;
  public Label startTime;
  public Label duration;

  EventView(Label name, Label desc, Label day, Label startTime, Label duration) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }


}
