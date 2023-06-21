package cs3500.pa05.view;

import cs3500.pa05.controller.TaskEventCreationController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * the implementation of the TaskEventView
 */
public class TaskEventViewImp implements TaskEventView {
  private FXMLLoader loader;

  /**
   * constructor
   *
   * @param controller the TaskEventCreationController
   */
  public TaskEventViewImp(TaskEventCreationController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("TaskEvent.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene for a TaskEvent part of the GUI layout.
   *
   * @return the layout
   *
   * @throws IllegalStateException if unable to load layout
   */
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
