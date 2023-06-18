package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    allTasks.getChildren().add(new Label("- " + this.name));
  }

}
