package cs3500.pa05.view;

import javafx.scene.Scene;

public interface DetailPopupView {
  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   */
  Scene load() throws IllegalStateException;
}

