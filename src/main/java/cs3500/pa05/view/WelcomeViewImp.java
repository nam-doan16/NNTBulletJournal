package cs3500.pa05.view;

import cs3500.pa05.controller.WelcomeController;
import cs3500.pa05.controller.WelcomeControllerImp;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class WelcomeViewImp implements WelcomeView{

  private FXMLLoader loader;
  public WelcomeViewImp(WelcomeController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Welcome.fxml"));
    this.loader.setController(controller);
  }

  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
