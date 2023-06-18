package cs3500.pa05.controller;

import cs3500.pa05.controller.TaskEventCreationController;
import cs3500.pa05.view.TaskEventView;
import cs3500.pa05.view.TaskEventViewImp;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class TaskEventCreationControllerImp implements TaskEventCreationController {

  private Popup popup;
  private Stage mainStage;

  private TaskEventView loader;

  @FXML
  private ComboBox menu;

  @FXML
  private Button close;


  public TaskEventCreationControllerImp(Stage mainStage) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    this.loader = new TaskEventViewImp(this);
    Scene s = loader.load();
    this.initButton();
    popup.getContent().add(s.getRoot());
  }

  private void initButton() {
    this.close.setOnAction(event -> this.popup.hide());
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
