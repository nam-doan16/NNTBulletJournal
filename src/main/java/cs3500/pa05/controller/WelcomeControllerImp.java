package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.json.WeekJson;
import cs3500.pa05.view.CalendarView;
import cs3500.pa05.view.CalendarViewImp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * the implementation of the WelcomeController
 */

public class WelcomeControllerImp implements WelcomeController {
  private Stage mainstage;
  private FileChooser chooser = new FileChooser();
  @FXML
  private Button newBujo;
  @FXML
  private Button previousBujo;
  @FXML
  private Button newWeek;

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
  public void run() throws IllegalStateException {
    this.newBujo.setOnAction(event -> switchtocal(event));
    this.newWeek.setOnAction(event -> {
      chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BUJO files (*.bujo)",
          "*.bujo"));
      File selected = chooser.showOpenDialog(null);
      if (selected != null) {
        try {
          ObjectMapper mapper = new ObjectMapper();
          JsonParser parser = mapper.getFactory().createParser(selected);
          WeekJson json = parser.readValueAs(WeekJson.class);
          createcal(new Converter().jsonToWeek(json), "template");
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });

    this.previousBujo.setOnAction(event -> {
      chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("BUJO files (*.bujo)",
          "*.bujo"));
      File selected = chooser.showOpenDialog(null);
      if (selected != null) {
        try {
          ObjectMapper mapper = new ObjectMapper();
          JsonParser parser = mapper.getFactory().createParser(selected);
          WeekJson json = parser.readValueAs(WeekJson.class);
          createcal(new Converter().jsonToWeek(json), "previous");
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  public void createcal(Week w, String version) {
    CalendarController c = new CalendarControllerImp(mainstage, w);
    CalendarView view = new CalendarViewImp(c);
    try {
      // load and place the view's scene onto the stage
      mainstage.setScene(view.load());
      mainstage.setTitle("Bujo File");
      c.run();
      mainstage.show();
      if(version.equals("previous")) {
        ((CalendarControllerImp) c).updatecal(w);
      } else {
        ((CalendarControllerImp) c).updatelayout(w);
      }
      // render the stage
    } catch (IllegalStateException exc) {
      exc.printStackTrace();
      //System.err.println("Unable to load GUI.");
    }
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
