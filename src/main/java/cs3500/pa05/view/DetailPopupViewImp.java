package cs3500.pa05.view;

import cs3500.pa05.controller.DetailPopupController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class DetailPopupViewImp implements DetailPopupView {
  private FXMLLoader loader;

  public DetailPopupViewImp(DetailPopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("TaskEventDetailPopup.fxml"));
    this.loader.setController(controller);
  }

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
