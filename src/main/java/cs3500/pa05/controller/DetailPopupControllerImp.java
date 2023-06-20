package cs3500.pa05.controller;

import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TaskEvent;
import cs3500.pa05.view.DetailPopupView;
import cs3500.pa05.view.DetailPopupViewImp;
import cs3500.pa05.view.TaskEventView;
import cs3500.pa05.view.TaskEventViewImp;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class DetailPopupControllerImp implements DetailPopupController {
  private Popup popup;
  private Stage mainStage;

  @FXML
  private HBox nameBox;

  @FXML
  private VBox descriptionBox;

  @FXML
  private HBox dayBox;

  @FXML
  private VBox extraBox;

  @FXML
  private Button done;



  public DetailPopupControllerImp(Stage mainStage, AbstTaskEvent taskEvent) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    DetailPopupView loader = new DetailPopupViewImp(this);
    Scene s = loader.load();
    taskEvent.fillDetails(nameBox, descriptionBox, dayBox, extraBox);
    popup.getContent().add(s.getRoot());
    this.done.setOnAction(event -> this.popup.hide());
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
