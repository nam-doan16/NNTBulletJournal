package cs3500.pa05.view;

import cs3500.pa05.controller.WelcomeController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * implementation for the WelcomeView
 */
public class WelcomeViewImp implements WelcomeView {

  private FXMLLoader loader;

  /**
   * constructor
   *
   * @param controller the WelcomeController
   */
  public WelcomeViewImp(WelcomeController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Welcome.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene from a welcome GUI layout.
   *
   * @return the layout
   *
   * @throws IllegalStateException if unable to load layout
   */
  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
