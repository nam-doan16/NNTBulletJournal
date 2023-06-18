package cs3500.pa05.controller;

import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TaskEvent;
import cs3500.pa05.view.TaskEventView;
import cs3500.pa05.view.TaskEventViewImp;
import java.util.List;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class TaskEventCreationControllerImp implements TaskEventCreationController {

  private Popup popup;
  private Stage mainStage;
  private TextField startTime;
  private TextField duration;
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


  public TaskEventCreationControllerImp(Stage mainStage, List<VBox> daysOfWeek, VBox allTasks) {
    this.daysOfWeek = daysOfWeek;
    this.mainStage = mainStage;
    this.allTasks = allTasks;
    this.popup = new Popup();
    TaskEventView loader = new TaskEventViewImp(this);
    Scene s = loader.load();
    this.initToggleTextField();
    this.initMenuButton();
    this.initAddButton();
    popup.getContent().add(s.getRoot());
  }

  private void initToggleTextField() {
    startTime = new TextField();
    startTime.setPromptText("Enter Start Time (e.g. 13:15)");
    duration = new TextField();
    duration.setPromptText("Enter a duration in minutes");
    vbox.getChildren().add(startTime);
    vbox.getChildren().add(duration);
  }

  private void initMenuButton() {
    this.close.setOnAction(event -> this.popup.hide());
    menu.setValue("Event");

    // switching on and off of the additional event information
    menu.getSelectionModel().selectedItemProperty().addListener((observable, prevOption,
                                                                 chosenOption) -> {
      if (chosenOption != null) {
        if (menu.getValue().equals(TaskEvent.TASK.displayName)) {
          startTime.setVisible(false);
          duration.setVisible(false);
        } else {
          startTime.setVisible(true);
          duration.setVisible(true);
        }
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

  private void initAddButton() {
    add.setOnAction(event -> {
      AbstTaskEvent taskEvent = null;
      String name = this.name.getText();
      String description = this.description.getText();
      Days day = Days.valueOf(dayMenu.getValue().toUpperCase());
      if (menu.getValue().equalsIgnoreCase(TaskEvent.TASK.displayName)) {
        taskEvent = new Task(name, description, day, allTasks);
      } else if (menu.getValue().equalsIgnoreCase(TaskEvent.EVENT.displayName)){
        String time = startTime.getText();
        String duration = this.duration.getText();
        taskEvent = new Event(name, description, day, time, duration);
      }

      daysOfWeek.get(chosenDayIndex).getChildren().add(taskEvent.getInfoButton());
    });
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
