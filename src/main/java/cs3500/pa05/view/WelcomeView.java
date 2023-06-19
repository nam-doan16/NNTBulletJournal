package cs3500.pa05.view;

import javafx.scene.Scene;

public interface WelcomeView {
  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   */
  Scene load() throws IllegalStateException;
}