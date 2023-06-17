package cs3500.pa05;

import cs3500.pa05.controller.CalendarController;
import cs3500.pa05.controller.CalendarControllerImp;
import cs3500.pa05.view.CalendarView;
import javafx.application.Application;
import javafx.stage.Stage;
import cs3500.pa05.view.CalendarViewImp;

/**
 * represents the driver of the program
 */
public class Driver extends Application {

  /**
   * main method
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    launch();
  }

  /**
   * starting the gui
   *
   * @param stage the primary stage for this application, onto which
   * the application scene can be set.
   * Applications may create other stages, if needed, but they will not be
   * primary stages.
   */
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
