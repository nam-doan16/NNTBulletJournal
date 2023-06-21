package cs3500.pa05.controller;

import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.view.CalendarView;
import cs3500.pa05.view.CalendarViewImp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * the implementation of the WelcomeController
 */
public class WelcomeControllerImp implements WelcomeController {

  private Stage mainstage;
  @FXML
  private Button NewBujo;

  /**
   * constructor
   *
   * @param mainstage the main stage of the GUI
   */
  public WelcomeControllerImp(Stage mainstage) {
    this.mainstage = mainstage;
  }

  /**
   * runs the welcome screen
   *
   * @throws IllegalStateException when something fails
   */
  public void run() throws IllegalStateException{
    this.NewBujo.setOnAction(event -> switchtocal(event));
  }

  /**
   * switches to calender controller on given action event
   *
   * @param e the action event given
   */
  public void switchtocal(ActionEvent e) {
    Week w = new Week();
    CalendarController c = new CalendarControllerImp(mainstage, w);
    CalendarView view = new CalendarViewImp(c);
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
