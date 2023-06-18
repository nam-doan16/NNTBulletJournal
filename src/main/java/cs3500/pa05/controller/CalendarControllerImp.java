package cs3500.pa05.controller;

/**
 * controller implementation for the calendar
 */
import cs3500.pa05.controller.CalendarController;
import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.controller.TaskEventCreationControllerImp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
  private VBox monday;

  private Stage mainStage;



  public CalendarControllerImp(Stage mainStage) {
    this.mainStage = mainStage;
  }

  /**
   * runs the program
   *
   * @throws IllegalStateException if it encounters any problems
   */
  @Override
  public void run() throws IllegalStateException {
    TaskEventCreationController d = new TaskEventCreationControllerImp(mainStage);
    addTaskButton.setOnAction(event -> d.showPopup());
  }

  @FXML
  private void handleAddTask() {

  }
}
