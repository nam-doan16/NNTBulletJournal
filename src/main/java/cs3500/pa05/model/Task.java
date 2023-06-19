package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Task extends AbstTaskEvent {
  private boolean complete;
  private VBox allTasks;
  public Task(String name, String description, Days dayOfWeek, VBox allTasks) {
    super(name, description, dayOfWeek);
    this.complete = false;
    this.allTasks = allTasks;
  }
  @Override
  public Button getInfoButton() {
    this.addTaskToQueue();
    Button button = new Button(this.name);
    return button;
  }

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
  }

}
