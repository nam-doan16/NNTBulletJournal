package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstTaskEvent {
  protected String name;
  protected String description;
  protected Days dayOfWeek;
  protected Button infoButton;

  public AbstTaskEvent(String name, String description, Days dayOfWeek) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
  }

  public abstract Button getInfoButton();

  public void fillDetails(HBox name, VBox description, HBox day, VBox extra) {
    name.getChildren().add(new Label(this.name));
    TextArea descriptionBox = new TextArea(this.description);
    descriptionBox.setEditable(false);
    description.getChildren().add(descriptionBox);
    day.getChildren().add(new Label(dayOfWeek.name()));
    this.addExtraDetails(extra);
  }

  public abstract void addExtraDetails(VBox extra);

  public void removeInstances(VBox vBox) {
    vBox.getChildren().remove(this.infoButton);
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public Days getDayOfWeek() {
    return this.dayOfWeek;
  }
}
