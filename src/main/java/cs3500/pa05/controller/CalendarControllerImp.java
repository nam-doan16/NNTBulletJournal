package cs3500.pa05.controller;

/**
 * controller implementation for the calendar
 */
import cs3500.pa05.controller.CalendarController;
import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.controller.TaskEventCreationControllerImp;
import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.Task;
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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalendarControllerImp implements CalendarController {

  /**
   * constructor
   */
  @FXML
  private Button addTaskButton;

  @FXML
  private VBox allTasks;

  @FXML
  private VBox sunday, monday, tuesday, wednesday, thursday, friday, saturday;

  private List<VBox> daysOfTheWeek;

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



  public CalendarControllerImp(Stage mainStage) {
    this.mainStage = mainStage;
  }

  private void initDaysOfTheWeek() {
    this.daysOfTheWeek = new ArrayList<>(List.of(sunday, monday, tuesday,
        wednesday, thursday, friday, saturday));
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

    changeSpaceTheme();
    changeScrapBookTheme();
    changeMinimalisticTheme();
    changeVintageTheme();

  }
  private void changeSpaceTheme() {
    AbstTheme space = new Space();
    this.spaceTheme.setOnAction(event -> {
      this.allTasks.setStyle("-fx-background-color: " + space.getBackgroundColor());
      this.monday.setStyle("-fx-background-color: " + space.getBackgroundColor());
    });
  }

  private void changeScrapBookTheme() {
    AbstTheme scrapbook = new ScrapBook();
    this.scrapbookTheme.setOnAction(event -> {
      this.allTasks.setStyle("-fx-background-color: " + scrapbook.getBackgroundColor());
      this.monday.setStyle("-fx-background-color: " + scrapbook.getBackgroundColor());
    });
  }

  private void changeMinimalisticTheme() {
    AbstTheme minimalistic = new Minimalistic();
    this.minimalTheme.setOnAction(event -> {
      this.allTasks.setStyle("-fx-background-color: " + minimalistic.getBackgroundColor());
      this.monday.setStyle("-fx-background-color: " + minimalistic.getBackgroundColor());
    });
  }

  private void changeVintageTheme() {
    AbstTheme vintage = new Vintage();
    this.vintageTheme.setOnAction(event -> {
      this.allTasks.setStyle("-fx-background-color: " + vintage.getBackgroundColor());
      this.monday.setStyle("-fx-background-color: " + vintage.getBackgroundColor());
    });
  }
}
