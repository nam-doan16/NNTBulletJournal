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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
  private MenuButton themeMenu;
  @FXML
  private VBox allTasks;

  @FXML
  private VBox sunday, monday, tuesday, wednesday, thursday, friday, saturday;
  @FXML
  private Label sundayLabel, mondayLabel, tuesdayLabel, wednesdayLabel, thursdayLabel,
      fridayLabel, saturdayLabel;
  @FXML
  private Label maxTasks, maxEvents;
  @FXML
  private Label allTasksLabel;
  @FXML
  private Label quotesLabel;
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
  @FXML
  private HBox quotesAndNotes;
  @FXML
  private HBox restrictionBox;


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
    for (VBox box : this.daysOfTheWeek) {
      box.setStyle("-fx-background-color: " + theme.getBackgroundColor());
    }
    for (Label label : this.labelsOfTheWeek) {
      label.setStyle("-fx-font-family: " + theme.getFontFamily()
          + "; -fx-text-fill: " + theme.getFontColor());
    }
    this.allTasksLabel.setStyle("-fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
    this.quotesLabel.setStyle("-fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
    this.quotesAndNotes.setStyle("-fx-background-color: " + theme.getBackgroundColor());
    this.weekDisplay.setStyle("-fx-background-color: " + theme.getBackgroundColor());
    this.savebutton.setStyle("-fx-background-color: " + theme.getBackgroundColor()
        + "; -fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
    this.addTaskButton.setStyle("-fx-background-color: " + theme.getBackgroundColor()
        + "; -fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
    this.themeMenu.setStyle("-fx-background-color: " + theme.getBackgroundColor()
        + "; -fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
    this.restrictionBox.setStyle("-fx-background-color: " + theme.getBackgroundColor());
    this.maxEvents.setStyle("-fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
    this.maxTasks.setStyle("-fx-font-family: " + theme.getFontFamily()
        + "; -fx-text-fill: " + theme.getFontColor());
  }

}
