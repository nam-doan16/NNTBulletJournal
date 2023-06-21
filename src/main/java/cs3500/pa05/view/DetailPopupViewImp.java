package cs3500.pa05.view;

import cs3500.pa05.controller.DetailPopupController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * implementation of the DetailPopupView
 */
public class DetailPopupViewImp implements DetailPopupView {
  private FXMLLoader loader;

  /**
   * constructor
   *
   * @param controller the DetailPopupController
   */
  public DetailPopupViewImp(DetailPopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("TaskEventDetailPopup.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene from the mini viewer
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
