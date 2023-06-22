package cs3500.pa05.controller;

import cs3500.pa05.view.LoginViewer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SplashController {
  @FXML
  private Button launch;
  Stage mainstage;

  public SplashController(Stage stage) {
    this.mainstage = stage;
  }

  public void run() {
    this.launch.setOnAction(event -> this.switchpasscode(event));
  }


  public void switchpasscode(ActionEvent e) {
    LoginController c = new LoginController(this.mainstage);
    LoginViewer view = new LoginViewer(c);

    try {
      // load and place the view's scene onto the stage
      mainstage.setScene(view.load());
      mainstage.setTitle("Bujo File");
      c.run();
      // render the stage
      mainstage.show();
    } catch (IllegalStateException exc) {
      exc.printStackTrace();
      //System.err.println("Unable to load GUI.");
    }
  }
}
