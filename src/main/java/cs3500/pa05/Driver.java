package cs3500.pa05;

import cs3500.pa05.controller.CalendarController;
import cs3500.pa05.controller.CalendarControllerImp;
import cs3500.pa05.view.CalendarView;
import javafx.application.Application;
import javafx.stage.Stage;
import cs3500.pa05.view.CalendarViewImp;

public class Driver extends Application {
  public static void main() {
    launch();
  }

  @Override
  public void start(Stage stage) {
    CalendarController c = new CalendarControllerImp();
    CalendarView view = new CalendarViewImp(c);

    try {
      // load and place the view's scene onto the stage
      stage.setScene(view.load());
      stage.setTitle("Bujo File");
      c.run();
      // render the stage
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }
}
