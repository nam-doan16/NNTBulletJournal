package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * view for the mini viewer for each task/event
 */
public interface DetailPopupView {
  /**
   * Loads a scene from the mini viewer
   *
   * @return the layout
   *
   * @throws IllegalStateException if unable to load layout
   */
  Scene load() throws IllegalStateException;
}

