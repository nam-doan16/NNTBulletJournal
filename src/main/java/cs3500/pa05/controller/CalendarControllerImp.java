package cs3500.pa05.controller;

/**
 * controller implementation for the calendar
 */
import cs3500.pa05.controller.CalendarController;
import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.controller.TaskEventCreationControllerImp;
import cs3500.pa05.json.Converter;
import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.theme.AbstTheme;
import cs3500.pa05.model.theme.Minimalistic;
import cs3500.pa05.model.theme.ScrapBook;
import cs3500.pa05.model.theme.Space;
import cs3500.pa05.model.theme.Vintage;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalendarControllerImp implements CalendarController {

  /**
   * constructor
   */
  private Week week;
  @FXML
  private Button addTaskButton;

  @FXML
  private VBox allTasks;

  @FXML
  private VBox sunday, monday, tuesday, wednesday, thursday, friday, saturday;
  @FXML
  private Label sundayLabel, mondayLabel, tuesdayLabel, wednesdayLabel, thursdayLabel,
      fridayLabel, saturdayLabel;
  @FXML
  private Label allTasksLabel;

  private List<VBox> daysOfTheWeek;
  private List<Label> labelsOfTheWeek;

  private Stage mainStage;

  @FXML
  private MenuItem scrapbookTheme;
  @FXML
  private MenuItem spaceTheme;
  @FXML
  private MenuItem minimalTheme;
  @FXML
  private MenuItem vintageTheme;
  @FXML
  private GridPane weekDisplay;
  @FXML
  private Button savebutton;



  public CalendarControllerImp(Stage mainStage, Week week) {
    this.mainStage = mainStage;
    this.week = week;
  }

  private void initDaysOfTheWeek() {
    this.daysOfTheWeek = new ArrayList<>(List.of(sunday, monday, tuesday,
        wednesday, thursday, friday, saturday));
    this.labelsOfTheWeek = new ArrayList<>(List.of(sundayLabel, mondayLabel, tuesdayLabel,
        wednesdayLabel, thursdayLabel, fridayLabel, saturdayLabel));
  }

  /**
   * runs the program
   *
   * @throws IllegalStateException if it encounters any problems
   */
  @Override
  public void run() throws IllegalStateException {
    this.initDaysOfTheWeek();
    TaskEventCreationController d = new TaskEventCreationControllerImp(mainStage, this.daysOfTheWeek, allTasks);
    addTaskButton.setOnAction(event -> d.showPopup());
    savebutton.setOnAction(event -> new SaveController(new Converter()).savetofiles(week));

    handleMenuItem();

  }
  private void handleMenuItem() {
    this.minimalTheme.setOnAction(event -> {
      changeTheme(new Minimalistic());
    });
    this.scrapbookTheme.setOnAction(event -> {
      changeTheme(new ScrapBook());
    });
    this.spaceTheme.setOnAction(event -> {
      changeTheme(new Space());
    });
    this.vintageTheme.setOnAction(event -> {
      changeTheme(new Vintage());
    });
  }

  private void changeTheme(AbstTheme theme) {
    this.allTasks.setStyle("-fx-background-color: " + theme.getBackgroundColor());
    this.monday.setStyle("-fx-background-color: " + theme.getBackgroundColor());
  }

}
