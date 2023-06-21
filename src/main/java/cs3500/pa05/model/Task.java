package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * represents a Task which extends the AbstTaskEvent class
 */
public class Task extends AbstTaskEvent {
  private boolean complete;
  private VBox allTasks;
  private VBox taskQueueInfo;

  /**
   * constructor
   *
   * @param name the name of the task
   * @param description the description of the task
   * @param dayOfWeek the day of the week that task is scheduled for
   * @param allTasks the layout manager for the GUI
   * @param link the link given by the user in the description
   */
  public Task(String name, String description, Days dayOfWeek, VBox allTasks, String link) {
    super(name, description, dayOfWeek, link);
    this.complete = false;
    this.allTasks = allTasks;
  }


  @Override
  public String[] getExtraDetails() {
    if (complete) {
      return new String[] {"COMPLETE? YES"};
    } else {
      return new String[] {"COMPLETE? NO"};
    }
  }

  /**
   * removes the task from the Calender GUI
   *
   * @param vBox a VBox
   */
  @Override
  public void removeInstances(VBox vBox) {
    super.removeInstances(vBox);
    this.allTasks.getChildren().remove(taskQueueInfo);
  }

}
