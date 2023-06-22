package cs3500.pa05.view;

import cs3500.pa05.controller.LoginController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class LoginViewer {
  private FXMLLoader loader;

  /**
   * constructor
   *
   * @param c the Calendar controller
   */
  public LoginViewer(LoginController c) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Login.fxml"));
    this.loader.setController(c);
  }

  /**
   * loads the calendar view
   *
   * @return a scene
   *
   * @throws IllegalStateException if layout unable to load
   */
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
