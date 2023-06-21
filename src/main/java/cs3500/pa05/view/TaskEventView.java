package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * the view for the TaskEvent part of the GUI
 */
public interface TaskEventView {
  /**
   * Loads a scene for a TaskEvent part of the GUI layout.
   *
   * @return the layout
   *
   * @throws IllegalStateException if unable to load layout
   */
  Scene load() throws IllegalStateException;
}
