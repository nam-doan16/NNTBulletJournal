package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * the view for the welcome GUI
 */
public interface WelcomeView {
  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   *
   * @throws IllegalStateException if unable to load layout
   */
  Scene load() throws IllegalStateException;
}
