package cs3500.pa05.controller;

import java.awt.Desktop;
import cs3500.pa05.model.AbstTaskEvent;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.view.DetailPopupView;
import cs3500.pa05.view.DetailPopupViewImp;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
                                  Week week, String givenLink) {
    this.mainStage = mainStage;
    this.popup = new Popup();
    this.week = week;
    DetailPopupView loader = new DetailPopupViewImp(this);
    Scene s = loader.load();
    taskEvent.fillDetails(nameBox, descriptionBox, dayBox, extraBox);
    popup.getContent().add(s.getRoot());
    this.done.setOnAction(event -> this.popup.hide());
    this.initDeleteButton(taskEvent, chosenDay);
    this.link = new Hyperlink(givenLink);
    this.addLink(givenLink);
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

  private void initDeleteButton(AbstTaskEvent taskEvent, VBox chosenDay) {
    deleteButton.setStyle("-fx-background-color: #ff0000; ");
    deleteButton.setOnAction(event -> {
      taskEvent.removeInstances(chosenDay);
      this.popup.hide();
    });
  }

  public void showPopup() {
    popup.show(mainStage);
  }
}
