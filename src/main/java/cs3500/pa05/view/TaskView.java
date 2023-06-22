package cs3500.pa05.view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the task view
 */
public class TaskView extends VBox {

  public Label name;
  public Label desc;
  public Label day;
  public CheckBox complete;


  TaskView(Label name, Label desc, Label day, CheckBox complete) {
    this.name = name;
    this.desc = desc;
    this.day = day;
    this.complete = complete;
  }

}
