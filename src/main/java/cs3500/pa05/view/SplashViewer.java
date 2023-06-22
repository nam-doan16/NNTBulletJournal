package cs3500.pa05.view;

import cs3500.pa05.controller.SplashController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SplashViewer {
  private FXMLLoader loader;

  /**
   * constructor
   *
   * @param c the Calendar controller
   */
  public SplashViewer(SplashController c) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Splash.fxml"));
    this.loader.setController(c);
  }

  /**
   * loads the calendar view
   *
   * @return a scene
   *
   * @throws IllegalStateException if layout unable to load
   */
  public Scene load() throws IllegalStateException {
    // TODO: implement
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
