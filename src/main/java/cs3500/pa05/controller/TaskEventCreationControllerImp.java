package cs3500.pa05.controller;

import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.view.TaskEventView;
import cs3500.pa05.view.TaskEventViewImp;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class TaskEventCreationControllerImp implements TaskEventCreationController {

  private Popup popup;
  private Stage mainStage;
  private TextField startTime;
  private TextField duration;

  private TaskEventView loader;

  @FXML
  private ComboBox menu;

  @FXML
  private Button close;

  @FXML
  private VBox vbox;


  public TaskEventCreationControllerImp(Stage mainStage) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    this.loader = new TaskEventViewImp(this);
    Scene s = loader.load();
    this.initToggleTextField();
    this.initButton();
    popup.getContent().add(s.getRoot());

  }

  private void initToggleTextField() {
    startTime = new TextField();
    startTime.setPromptText("Enter Start Time (e.g. 13:15)");
    duration = new TextField();
    duration.setPromptText("Enter a duration in minutes");
    vbox.getChildren().add(startTime);
    vbox.getChildren().add(duration);
    startTime.setVisible(false);
    duration.setVisible(false);
  }

  private void initButton() {
    this.close.setOnAction(event -> this.popup.hide());

    // switching on and off of the additional event information
    menu.getSelectionModel().selectedItemProperty().addListener((observable, prevOption,
                                                                 chosenOption) -> {
      if (chosenOption != null) {
        if ("Task".equals(menu.getValue())) {
          startTime.setVisible(false);
          duration.setVisible(false);
        } else if ("Event".equals(menu.getValue())) {
          startTime.setVisible(true);
          duration.setVisible(true);
        }
      }
    });
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
