package cs3500.pa05.view;

import cs3500.pa05.controller.CalendarController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class CalendarViewImp implements CalendarView {
  private FXMLLoader loader;

  public CalendarViewImp(CalendarController c) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Calendar.fxml"));
    this.loader.setController(c);
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
