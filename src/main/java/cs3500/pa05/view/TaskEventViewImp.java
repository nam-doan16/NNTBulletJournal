package cs3500.pa05.view;

import cs3500.pa05.controller.TaskEventCreationController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class TaskEventViewImp implements TaskEventView {
  private FXMLLoader loader;

  public TaskEventViewImp(TaskEventCreationController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("TaskEvent.fxml"));
    this.loader.setController(controller);
  }

  @Override
  public Scene load() throws IllegalStateException {
    // TODO: implement
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
