package cs3500.pa05.controller;

import cs3500.pa05.view.CalendarView;
import cs3500.pa05.view.CalendarViewImp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeControllerImp implements WelcomeController {

  private Stage mainstage;
  @FXML
  private Button NewBujo;

  public WelcomeControllerImp(Stage mainstage) {
    this.mainstage = mainstage;
  }

  public void run() throws IllegalStateException{
    this.NewBujo.setOnAction(event -> switchtocal(event));
  }

  public void switchtocal(ActionEvent e) {
    CalendarController c = new CalendarControllerImp(mainstage);
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
