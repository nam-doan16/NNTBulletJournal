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

  /**
   * constructor
   *
   * @param name the name of the task
   * @param description the description of the task
   * @param dayOfWeek the day of the week that task is scheduled for
   * @param link the link given by the user in the description
   */
  public Task(String name, String description, Days dayOfWeek, String link) {
    super(name, description, dayOfWeek, link);
    this.complete = false;



  @Override
  public String[] getExtraDetails() {
    if (complete) {
      return new String[] {"COMPLETE? YES"};
    } else {
      return new String[] {"COMPLETE? NO"};
    }
  }

}
