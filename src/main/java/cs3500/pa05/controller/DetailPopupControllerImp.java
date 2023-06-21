package cs3500.pa05.controller;

import java.awt.Desktop;
import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.view.DetailPopupView;
import cs3500.pa05.view.DetailPopupViewImp;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;

public class DetailPopupControllerImp implements DetailPopupController {
  private Week week;
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

  @FXML
  private Hyperlink link;

  public DetailPopupControllerImp(Stage mainStage, AbstTaskEvent taskEvent, VBox chosenDay,
                                  Button infoButton, VBox allTasks, VBox taskQueue,
                                  Week week, String givenLink) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    this.week = week;
    DetailPopupView loader = new DetailPopupViewImp(this);
    Scene s = loader.load();
    popup.getContent().add(s.getRoot());
    this.done.setOnAction(event -> this.popup.hide());
    this.fillDetails(taskEvent);
    this.initDeleteButton(chosenDay, infoButton, allTasks, taskQueue);
    this.link = new Hyperlink(givenLink);
    this.addLink(givenLink);
  }

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

  private void initDeleteButton(VBox chosenDay, Button infoButton, VBox allTasks, VBox taskQueue) {
    deleteButton.setStyle("-fx-background-color: #ff0000; ");
    deleteButton.setOnAction(event -> {
      chosenDay.getChildren().remove(infoButton);
      allTasks.getChildren().remove(taskQueue);
      this.popup.hide();
    });
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
