package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.theme.AbstTheme;
import cs3500.pa05.model.theme.Minimalistic;
import cs3500.pa05.model.theme.ScrapBook;
import cs3500.pa05.model.theme.Space;
import cs3500.pa05.model.theme.Vintage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * controller implementation for the calendar
 */
public class CalendarControllerImp implements CalendarController {

  /**
   * constructor
   */
  private final Week week;
  private final FileChooser chooser = new FileChooser();
  @FXML
  private Button addTaskButton;
  @FXML
  private MenuButton themeMenu;
  @FXML
  private VBox allTasks;
  @FXML private ScrollPane scroll0;
  @FXML private ScrollPane scroll1;
  @FXML private ScrollPane scroll2;
  @FXML private ScrollPane scroll3;
  @FXML private ScrollPane scroll4;
  @FXML private ScrollPane scroll5;
  @FXML private ScrollPane scroll6;

  @FXML private VBox sunday;
  @FXML private VBox monday;
  @FXML private VBox tuesday;
  @FXML private VBox wednesday;
  @FXML private VBox thursday;
  @FXML private VBox friday;
  @FXML private VBox saturday;

  @FXML private Label sundayLabel;
  @FXML private Label mondayLabel;
  @FXML private Label tuesdayLabel;
  @FXML private Label wednesdayLabel;
  @FXML private Label thursdayLabel;
  @FXML private Label fridayLabel;
  @FXML private Label saturdayLabel;

  @FXML private Label maxTasks;
  @FXML private Label maxEvents;

  @FXML private TextField maxe;
  @FXML private TextField maxt;

  @FXML
  private Label allTasksLabel;
  @FXML
  private Label quotesLabel;
  private List<VBox> daysOfTheWeek;
  private List<Label> labelsOfTheWeek;
  private List<ScrollPane> scrollPanesOfTheWeek;
  private final Stage mainStage;
  @FXML
  private MenuButton weekStart;
  @FXML
  private MenuItem sunStart;
  @FXML
  private MenuItem monStart;
  @FXML
  private MenuItem tueStart;
  @FXML
  private MenuItem wedStart;
  @FXML
  private MenuItem thuStart;
  @FXML
  private MenuItem friStart;
  @FXML
  private MenuItem satStart;
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
  @FXML
  private TextArea qandn;

  /**
   * constructor for CalendarController
   *
   * @param mainStage the stage for the calendar view (with the week displayed)
   * @param week the current week being displayed on the calendar view
   */
  public CalendarControllerImp(Stage mainStage, Week week) {
    this.mainStage = mainStage;
    this.week = week;
  }

  /**
   * initializes lists containing the JavaFX components of the week
   * daysOfTheWeek initialized to new ArrayList of VBoxes (sunday, monday, etc)
   * labelsOfTheWeek initialized to a new ArrayList of Labels (sundayLabel, mondayLabel etc)
   */
  private void initDaysOfTheWeek() {
    this.daysOfTheWeek = new ArrayList<>(List.of(sunday, monday, tuesday,
        wednesday, thursday, friday, saturday));
    this.labelsOfTheWeek = new ArrayList<>(List.of(sundayLabel, mondayLabel,
        tuesdayLabel, wednesdayLabel, thursdayLabel, fridayLabel, saturdayLabel));
    this.scrollPanesOfTheWeek = new ArrayList<>(List.of(scroll0, scroll1, scroll2, scroll3,
        scroll4, scroll5, scroll6));

    for (int i = 0; i < daysOfTheWeek.size(); i++) {
      this.daysOfTheWeek.get(i).getChildren().add(this.labelsOfTheWeek.get(i));
    }
  }

  /**
   * runs the program
   *
   * @throws IllegalStateException if it encounters any problems
   */
  @Override
  public void run() throws IllegalStateException {
    this.initDaysOfTheWeek();
    TaskEventCreationController d = new TaskEventCreationControllerImp(mainStage,
        this.daysOfTheWeek, allTasks, this.week, maxe, maxt);
    addTaskButton.setOnAction(event -> d.showPopup());
    savebutton.setOnAction(
        event -> {
          week.setqandn(qandn.getText());
          week.setMaxt(Integer.parseInt(maxt.getText()));
          week.setMaxe(Integer.parseInt(maxe.getText()));
          File file = chooser.showOpenDialog(mainStage);
          if (file != null) {
            try {
              SaveController s = new SaveController(mainStage, new Converter(), week);
              s.savetofiles(file);
            } catch (IOException ex) {
              throw new RuntimeException(ex);
            }
          }
        });
    handleMenuItem();
    handleWeekStart();
  }

  /**
   * Handles the changing of the state of the current day that starts the week
   */
  public void handleWeekStart() {
    this.sunStart.setOnAction(event -> {
      changeWeekStart(Days.SUNDAY.numRepresentation);
      week.setStart("Sunday");
    });
    this.monStart.setOnAction(event -> {
      changeWeekStart(Days.MONDAY.numRepresentation);
      week.setStart("Monday");
    });
    this.tueStart.setOnAction(event -> {
      changeWeekStart(Days.TUESDAY.numRepresentation);
      week.setStart("Tuesday");
    });
    this.wedStart.setOnAction(event -> {
      changeWeekStart(Days.WEDNESDAY.numRepresentation);
      week.setStart("Wednesday");
    });
    this.thuStart.setOnAction(event -> {
      changeWeekStart(Days.THURSDAY.numRepresentation);
      week.setStart("Thursday");
    });
    this.friStart.setOnAction(event -> {
      changeWeekStart(Days.FRIDAY.numRepresentation);
      week.setStart("Friday");
    });
    this.satStart.setOnAction(event -> {
      changeWeekStart(Days.SATURDAY.numRepresentation);
      week.setStart("Saturday");
    });

  }

  /**
   * Changes the week start day to the given day
   *
   * @param day integer representation of the day
   */
  public void changeWeekStart(int day) {
    int index = 0;
    for (int i = day; i < daysOfTheWeek.size(); i++) {
      this.scrollPanesOfTheWeek.get(index).setContent(this.daysOfTheWeek.get(i));
      index++;
      if (index == daysOfTheWeek.size()) {
        break;
      }
    }

    for (int i = 0; i < day; i++) {
      this.scrollPanesOfTheWeek.get(index).setContent(this.daysOfTheWeek.get(i));
      index++;
      if (index == daysOfTheWeek.size()) {
        break;
      }
    }
  }

  /**
   * handles mouse clicks for each menuItem (minimalTheme, scrapbookTheme etc)
   * basically allows the user to click on whichever theme they want and changes the calendar
   * to fit the appropriate theme
   */
  private void handleMenuItem() {
    this.minimalTheme.setOnAction(event -> {
      changeTheme(new Minimalistic());
      week.setThem(new Minimalistic());
    });
    this.scrapbookTheme.setOnAction(event -> {
      changeTheme(new ScrapBook());
      week.setThem(new ScrapBook());
    });
    this.spaceTheme.setOnAction(event -> {
      changeTheme(new Space());
      week.setThem(new Space());
    });
    this.vintageTheme.setOnAction(event -> {
      changeTheme(new Vintage());
      week.setThem(new Vintage());
    });
  }

  /**
   * changes the JavaFX elements on the GUI to fit the given theme
   *
   * @param theme the theme that the user wants the GUI application to be in
   */
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

  /**
   * updates the info in the week for persistence
   *
   * @param w a week object
   */
  public void updatecal(Week w) {
    String theme = w.getTheme();
    if (theme.equals("minimal")) {
      this.changeTheme(new Minimalistic());
    }
    if (theme.equals("scrapbook")) {
      this.changeTheme(new ScrapBook());
    }
    if (theme.equals("vintage")) {
      this.changeTheme(new Vintage());
    }
    if (theme.equals("space")) {
      this.changeTheme(new Space());
    }
    this.changeWeekStart(week.getint());
    maxe.setText(String.valueOf(w.getMaxe()));
    maxt.setText(String.valueOf(w.getMaxt()));
    qandn.setText(w.getQandn());

    for (Task t : week.getTasks()) {
      Button infoButton = new Button(t.getName());
      VBox taskToQueue = null;
      DetailPopupController infoPopup = new DetailPopupControllerImp(mainStage, t,
          daysOfTheWeek.get(t.getDayOfWeek().ordinal()), infoButton, allTasks,
          taskToQueue, t.getLink());
      infoButton.setOnAction(click -> infoPopup.showPopup());
      daysOfTheWeek.get(t.getDayOfWeek().ordinal()).getChildren().add(infoButton);
      VBox task = new VBox();
      task.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
      task.setSpacing(10);
      task.getChildren().add(new Label("- " + t.getName()));
      Label completeness = new Label("  " + t.getExtraDetails()[0]);
      String toggleButtonString;
      if (completeness.getText().contains("YES")) {
        toggleButtonString = "Mark as incomplete";
      } else {
        toggleButtonString = "Mark as complete";
      }
      task.getChildren().add(completeness);

      // having a button to toggle completeness/incompleteness
      Button toggleComplete = new Button(toggleButtonString);
      toggleComplete.setOnAction(event -> {
        if (completeness.getText().contains("NO")) {
          completeness.setText("  Complete? YES");
          toggleComplete.setText("Mark as incomplete");
        } else {
          completeness.setText("  Complete? NO");
          toggleComplete.setText("Mark as complete");
        }
      });
      task.getChildren().add(toggleComplete);
      allTasks.getChildren().add(task);
    }

    for (Event e : w.getEvents()) {
      Button infoButton = new Button(e.getName());
      VBox taskToQueue = null;
      DetailPopupController infoPopup = new DetailPopupControllerImp(mainStage, e,
          daysOfTheWeek.get(e.getDayOfWeek().ordinal()), infoButton, allTasks,
          taskToQueue, e.getLink());
      infoButton.setOnAction(click -> infoPopup.showPopup());
      daysOfTheWeek.get(e.getDayOfWeek().ordinal()).getChildren().add(infoButton);
    }
  }

  /**
   * updates the info for each week for persistence
   *
   * @param w a week object to store info for persistence
   */
  public void updatelayout(Week w) {
    String theme = w.getTheme();
    if (theme.equals("minimal")) {
      this.changeTheme(new Minimalistic());
    }
    if (theme.equals("scrapbook")) {
      this.changeTheme(new ScrapBook());
    }
    if (theme.equals("vintage")) {
      this.changeTheme(new Vintage());
    }
    if (theme.equals("space")) {
      this.changeTheme(new Space());
    }
    this.changeWeekStart(week.getint());
    maxe.setText(String.valueOf(w.getMaxe()));
    maxt.setText(String.valueOf(w.getMaxt()));
    qandn.setText(w.getQandn());
    w.setTasks(new ArrayList<>());
    w.setEvents(new ArrayList<>());
  }
}
