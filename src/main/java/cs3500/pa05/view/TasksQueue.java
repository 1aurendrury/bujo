package cs3500.pa05.view;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the task queue
 */
public class TasksQueue extends VBox {

  public Label tasksQueueLabel;
  public List<TaskView> tasks;

  public TasksQueue(Label tasksQueueLabel, List<TaskView> tasks) {
    this.tasksQueueLabel = tasksQueueLabel;
    this.tasks = tasks;
  }


}
