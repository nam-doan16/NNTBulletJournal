package cs3500.pa05.controller;

import cs3500.pa05.view.WelcomeView;
import cs3500.pa05.view.WelcomeViewImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * Represents the controller for the Login part of the GUI
 */
public class LoginController {
  @FXML
  private Button enter;
  private Stage mainStage;
  @FXML
  private PasswordField passcode;

  /**
   * constructor
   *
   * @param s the main stage of this application
   */
  public LoginController(Stage s) {
    this.mainStage = s;
  }

  /**
   * runs the login controller
   */
  public void run() {
    this.enter.setOnAction(event -> switchtowelcome(event));
  }

  /**
   * switches from login to welcome screen
   *
   * @param e the action event that allows for the switch
   */
  public void switchtowelcome(ActionEvent e) {
    if (passcode.getText().equals("nclliu")) {
      WelcomeController c = new WelcomeControllerImp(this.mainStage);
      WelcomeView view = new WelcomeViewImp(c);
      try {
        // load and place the view's scene onto the stage
        mainStage.setScene(view.load());
        mainStage.setTitle("Bujo File");
        c.run();
        // render the stage
        mainStage.show();
      } catch (IllegalStateException exc) {
        exc.printStackTrace();
        //System.err.println("Unable to load GUI.");
      }
    } else {
      passcode.clear();
      passcode.setPromptText("TRY AGAIN!");
    }
  }
}



