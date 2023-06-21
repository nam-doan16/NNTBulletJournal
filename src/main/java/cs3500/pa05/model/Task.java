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
    this.infoButton = new Button("Task: " + this.name);
  }

  /**
   * getter for infoButton
   *
   * @return a Button
   */
  @Override
  public Button getInfoButton() {
    this.addTaskToQueue();
    return this.infoButton;
  }

  /**
   * adds a task to the Task Queue
   */
  private void addTaskToQueue() {
    // initializing buttons
    VBox task = new VBox();
    task.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    task.setSpacing(10);
    task.getChildren().add(new Label("- " + this.name));
    Label completeness;
    String toggleButtonString;
    if (complete) {
      completeness = new Label("  Complete? YES");
      toggleButtonString = "Mark as incomplete";
    } else {
      completeness = new Label("  Complete? NO");
      toggleButtonString = "Mark as complete";
    }
    task.getChildren().add(completeness);

    // having a button to toggle completeness/incompleteness
    Button toggleComplete = new Button(toggleButtonString);
    toggleComplete.setOnAction(event -> {
      complete = !complete;
      if (complete) {
        completeness.setText("  Complete? YES");
        toggleComplete.setText("Mark as incomplete");
      } else {
        completeness.setText("  Complete? NO");
        toggleComplete.setText("Mark as complete");
      }
    });
    task.getChildren().add(toggleComplete);
    allTasks.getChildren().add(task);
    this.taskQueueInfo = task;
  }

  /**
   * adds whether or not the task is complete
   *
   * @param extra a VBox
   */
  @Override
  public void addExtraDetails(VBox extra) {
    StringBuilder string = new StringBuilder("COMPLETE? ");
    if (complete) {
      string.append("YES");
    } else {
      string.append("NO");
    }

    extra.getChildren().add(new Label(string.toString()));
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
