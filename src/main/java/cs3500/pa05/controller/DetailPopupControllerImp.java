package cs3500.pa05.controller;

import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.view.DetailPopupView;
import cs3500.pa05.view.DetailPopupViewImp;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Implementation class for DetailPopupController
 */
public class DetailPopupControllerImp implements DetailPopupController {
  private final Popup popup;
  private final Stage mainStage;

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

  @FXML
  private final Hyperlink link;

  /**
   * Constructor for DetailPopupControllerImp
   *
   * @param mainStage main stage (calendar)
   * @param taskEvent task/event
   * @param chosenDay VBox of a specific day
   * @param infoButton reference to a button in the vbox of the chosen day
   * @param allTasks reference to the VBox with the task queues
   * @param taskQueue reference to a task in the task queue
   * @param givenLink String representation of a link
   */
  public DetailPopupControllerImp(Stage mainStage, AbstTaskEvent taskEvent, VBox chosenDay,
                                  Button infoButton, VBox allTasks, VBox taskQueue,
                                  String givenLink) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    DetailPopupView loader = new DetailPopupViewImp(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    this.done.setOnAction(event -> this.popup.hide());
    this.fillDetails(taskEvent);
    this.initDeleteButton(chosenDay, infoButton, allTasks, taskQueue);
    this.link = new Hyperlink(givenLink);
    this.addLink(givenLink);
  }

  /**
   * Fills the popup with taskEvent's information
   *
   * @param taskEvent task/event
   */
  private void fillDetails(AbstTaskEvent taskEvent) {
    nameBox.getChildren().add(new Label(taskEvent.getName()));
    TextArea descriptionBox = new TextArea(taskEvent.getDescription());
    descriptionBox.setEditable(false);
    this.descriptionBox.getChildren().add(descriptionBox);
    dayBox.getChildren().add(new Label(taskEvent.getDayOfWeek().name()));
    for (String extraInfo : taskEvent.getExtraDetails()) {
      extraBox.getChildren().add(new Label(extraInfo));
    }
  }

  /**
   * Adds the given string representation of a link to the popup
   *
   * @param givenLink string representation of a valid link
   */
  public void addLink(String givenLink) {
    this.descriptionBox.getChildren().add(this.link);
    this.link.setOnAction(event -> {
      try {
        Desktop.getDesktop().browse(new URI(givenLink));
      } catch (URISyntaxException | IOException e) {
        e.getMessage();
      }
    });
  }

  /**
   * Initializes the delete buttons's functionality
   *
   * @param chosenDay reference to Vbox of a certain day
   * @param infoButton reference to a Button in chosenDay
   * @param allTasks reference to a VBox of all tasks
   * @param taskQueue reference to a Task in the VBox
   */
  private void initDeleteButton(VBox chosenDay, Button infoButton, VBox allTasks, VBox taskQueue) {
    deleteButton.setStyle("-fx-background-color: #ff0000; ");
    deleteButton.setOnAction(event -> {
      chosenDay.getChildren().remove(infoButton);
      allTasks.getChildren().remove(taskQueue);
      this.popup.hide();
    });
  }

  /**
   * Shows this popup
   */
  public void showPopup() {
    popup.show(mainStage);
  }
}
