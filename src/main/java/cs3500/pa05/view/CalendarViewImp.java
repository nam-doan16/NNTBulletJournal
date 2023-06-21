package cs3500.pa05.view;

import cs3500.pa05.controller.CalendarController;
import cs3500.pa05.model.theme.AbstTheme;
import cs3500.pa05.model.theme.Minimalistic;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarViewImp implements CalendarView {
  private FXMLLoader loader;

  public CalendarViewImp(CalendarController c) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("Calendar.fxml"));
    this.loader.setController(c);
//    Parent root = this.loader.getRoot();
//    Scene scene = new Scene(root);
//    String css = this.getClass().getResource("Minimal.css").toExternalForm();
//    scene.getStylesheets().add(css);
//    stage.setScene(scene);
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

  public void setTheme(AbstTheme theme) {

  }

  public void changeScene(Stage stage) {
    Parent root = this.loader.getRoot();
    Scene scene = new Scene(root);
    String css = this.getClass().getResource("Minimal.css").toExternalForm();
    scene.getStylesheets().add(css);
    stage.setScene(scene);
  }
}
