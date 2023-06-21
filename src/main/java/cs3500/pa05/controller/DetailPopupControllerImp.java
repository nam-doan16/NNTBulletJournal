package cs3500.pa05.controller;

import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.view.DetailPopupView;
import cs3500.pa05.view.DetailPopupViewImp;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;

/**
 * the implementation for the DetailPopupController
 */
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

  @FXML
  private Button deleteButton;

  /**
   * constructor
   *
   * @param mainStage the main stage of the GUI
   * @param taskEvent the AbstTaskEvent the popup is for
   * @param chosenDay the day that the taskEvent is scheduled for
   */
  public DetailPopupControllerImp(Stage mainStage, AbstTaskEvent taskEvent, VBox chosenDay) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    DetailPopupView loader = new DetailPopupViewImp(this);
    Scene s = loader.load();
    taskEvent.fillDetails(nameBox, descriptionBox, dayBox, extraBox);
    popup.getContent().add(s.getRoot());
    this.done.setOnAction(event -> this.popup.hide());
    this.initDeleteButton(taskEvent, chosenDay);
  }

  /**
   * initializes the delete button on the mini viewer
   *
   * @param taskEvent the AbstTaskEvent that the delete button belongs to
   * @param chosenDay the day the AbstTaskEvent is scheduled for
   */
  private void initDeleteButton(AbstTaskEvent taskEvent, VBox chosenDay) {
    deleteButton.setStyle("-fx-background-color: #ff0000; ");
    deleteButton.setOnAction(event -> {
      taskEvent.removeInstances(chosenDay);
      this.popup.hide();
    });
  }

  /**
   * displays the mini viewer
   */
  public void showPopup() {
    popup.show(mainStage);
  }
}
