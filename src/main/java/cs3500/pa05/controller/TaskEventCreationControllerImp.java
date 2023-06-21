package cs3500.pa05.controller;

import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.ArgumentValidator;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TaskEvent;
import cs3500.pa05.model.enums.TimeNotation;
import cs3500.pa05.view.TaskEventView;
import cs3500.pa05.view.TaskEventViewImp;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * implementation of the TaskEventCreationController
 */
public class TaskEventCreationControllerImp implements TaskEventCreationController {

  private Popup popup;
  private Stage mainStage;
  private List<VBox> daysOfWeek;
  private int chosenDayIndex;
  private VBox allTasks;

  @FXML
  private ComboBox<String> menu;

  @FXML
  private TextField name;

  @FXML
  private TextField description;

  @FXML
  private ComboBox<String> dayMenu;

  @FXML
  private Button close;

  @FXML
  private VBox vbox;

  @FXML
  private Button add;

  @FXML
  private VBox eventOptions;

  @FXML
  private TextField startTime;

  @FXML
  private TextField duration;

  @FXML
  private ComboBox<String> ampm;

  @FXML
  private VBox errorBox;

  /**
   * constructor
   *
   * @param mainStage the main stage of the GUI
   * @param daysOfWeek a list of VBoxes representing each day of the week
   * @param allTasks task queue for each day
   */
  public TaskEventCreationControllerImp(Stage mainStage, List<VBox> daysOfWeek, VBox allTasks) {
    this.daysOfWeek = daysOfWeek;
    this.mainStage = mainStage;
    this.allTasks = allTasks;
    this.popup = new Popup();
    TaskEventView loader = new TaskEventViewImp(this);
    Scene s = loader.load();
    this.initMenuButton();
    this.initAddButton();
    popup.getContent().add(s.getRoot());
  }

  /**
   * initializes the MenuButton for the TaskEvent
   */
  private void initMenuButton() {
    this.close.setOnAction(event -> this.popup.hide());
    menu.setValue("Event");
    ampm.setValue("PM");

    // switching on and off of the additional event information
    menu.getSelectionModel().selectedItemProperty().addListener((observable, prevOption,
                                                                 chosenOption) -> {
      if (chosenOption != null) {
        eventOptions.setVisible(!menu.getValue().equals(TaskEvent.TASK.displayName));
      }
    });

    dayMenu.setValue("Sunday");
    // listener for day of week menu
    dayMenu.getSelectionModel().selectedItemProperty().addListener((observable, prevOption,
                                                                 chosenOption) -> {
      if (chosenOption != null) {
        for (Days day : Days.values()) {
          if (dayMenu.getValue().equalsIgnoreCase(day.toString())) {
            chosenDayIndex = day.ordinal();
          }
        }
      }
    });
  }

  /**
   * initializes the add TaskEvent button
   */
  private void initAddButton() {
    // TODO: Make it so every time add is clicked, it's empty
    add.setOnAction(event -> {
      boolean addButton = true;
      AbstTaskEvent taskEvent = null;
      StringBuilder errorMessage = new StringBuilder("Error! ");
      String name = this.name.getText();
      String description = this.description.getText();
      Hyperlink link = ArgumentValidator.linkParser(description);
      Days day = Days.valueOf(dayMenu.getValue().toUpperCase());
      try {
        ArgumentValidator.nonEmptyName(name);
      } catch (IllegalArgumentException e) {
        errorMessage.append(e.getMessage() + " ");
        addButton = false;
      }
      if (menu.getValue().equalsIgnoreCase(TaskEvent.TASK.displayName)) {
        taskEvent = new Task(name, description, day, allTasks, link);
      } else if (menu.getValue().equalsIgnoreCase(TaskEvent.EVENT.displayName)){
        try {
          String time = ArgumentValidator.checkTimeFormat(startTime.getText());
          int duration = ArgumentValidator.checkStringNumber(this.duration.getText(), "Invalid duration");
          taskEvent = new Event(name, description, day, time,
              TimeNotation.valueOf(ampm.getValue()), duration, link);
        } catch (IllegalArgumentException e) {
          errorMessage.append(e.getMessage());
          addButton = false;
        }
      }
      errorBox.getChildren().clear();
      if (addButton) {
        Button infoButton = taskEvent.getInfoButton();
        DetailPopupController infoPopup = new DetailPopupControllerImp(mainStage, taskEvent, daysOfWeek.get(chosenDayIndex));
        infoButton.setOnAction(click -> infoPopup.showPopup());
        daysOfWeek.get(chosenDayIndex).getChildren().add(infoButton);
        this.popup.hide();
      } else {
        Label errorMessageLabel = new Label(errorMessage.toString());
        errorMessageLabel.setTextFill(Color.RED);
        errorBox.getChildren().add(errorMessageLabel);
      }
    });
  }

  /**
   * displays the TaskEvent to the GUI
   */
  public void showPopup() {
    popup.show(mainStage);
  }
}
