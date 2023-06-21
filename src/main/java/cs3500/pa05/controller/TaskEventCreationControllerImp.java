package cs3500.pa05.controller;

import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.ArgumentValidator;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.adapterclasses.Week;
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

public class TaskEventCreationControllerImp implements TaskEventCreationController {
  private Week week;
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


  public TaskEventCreationControllerImp(Stage mainStage, List<VBox> daysOfWeek, VBox allTasks, Week week) {
    this.week = week;
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

  private void initAddButton() {
    add.setOnAction(event -> {
      boolean addButton = true;
      AbstTaskEvent taskEvent = null;
      StringBuilder errorMessage = new StringBuilder("Error! ");
      String description = this.description.getText();
      String link = ArgumentValidator.giveValidLink(description);
      Days day = Days.valueOf(dayMenu.getValue().toUpperCase());
      try {
        String name = ArgumentValidator.nonEmptyName(this.name.getText());
        if (menu.getValue().equalsIgnoreCase(TaskEvent.TASK.displayName)) {
          taskEvent = new Task(name, description, day, link);
        } else if (menu.getValue().equalsIgnoreCase(TaskEvent.EVENT.displayName)){
          String time = ArgumentValidator.checkTimeFormat(startTime.getText());
          int duration = ArgumentValidator.checkStringPosNumber(this.duration.getText(),
              "Invalid duration");
          taskEvent = new Event(name, description, day, time,
              TimeNotation.valueOf(ampm.getValue()), duration, link);
        }
      } catch (IllegalArgumentException e) {
        errorMessage.append(e.getMessage());
        addButton = false;
      }
      errorBox.getChildren().clear();
      if (addButton) {
        this.setupInfoButton(taskEvent, link);
        this.popup.hide();
      } else {
        Label errorMessageLabel = new Label(errorMessage.toString());
        errorMessageLabel.setTextFill(Color.RED);
        errorBox.getChildren().add(errorMessageLabel);
      }
    });
  }

  private void setupInfoButton(AbstTaskEvent taskEvent, String link) {
    Button infoButton = new Button(taskEvent.getName());
    VBox taskToQueue = null;
    for (String string : taskEvent.getExtraDetails()) {
      if (string.contains("COMPLETE?")) {
        taskToQueue = this.getTaskQueue(taskEvent);
      }
    }
    DetailPopupController infoPopup = new DetailPopupControllerImp(mainStage, taskEvent,
        daysOfWeek.get(chosenDayIndex), infoButton, allTasks, taskToQueue, this.week, link);
    infoButton.setOnAction(click -> infoPopup.showPopup());
    daysOfWeek.get(chosenDayIndex).getChildren().add(infoButton);
  }

  private VBox getTaskQueue(AbstTaskEvent taskEvent) {
    // initializing buttons
    VBox task = new VBox();
    task.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    task.setSpacing(10);
    task.getChildren().add(new Label("- " + taskEvent.getName()));
    Label completeness = new Label("  " + taskEvent.getExtraDetails()[0]);
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
    return task;
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
