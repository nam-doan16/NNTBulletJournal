package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * represents an abstract TaskEvent
 */
public abstract class AbstTaskEvent {
  protected String name;
  protected String description;
  protected Days dayOfWeek;
  protected Hyperlink link;
  protected Button infoButton;

  /**
   * constructor
   *
   * @param name the name of the event/task
   * @param description the description of the task/event
   * @param dayOfWeek the day of the week the task/event is scheduled for
   * @param link the link given by the user in the description
   */
  public AbstTaskEvent(String name, String description, Days dayOfWeek, Hyperlink link) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
    this.link = link;
  }

  /**
   * getter for infoButton
   *
   * @return a Button
   */
  public abstract Button getInfoButton();

  /**
   * fills in the details of the task/event on the GUI
   *
   * @param name of the task/event
   * @param description of the task/event
   * @param day the task/event takes place
   * @param extra for whether or not it is complete
   */
  public void fillDetails(HBox name, VBox description, HBox day, VBox extra) {
    name.getChildren().add(new Label(this.name));
    TextArea descriptionBox = new TextArea(this.description);
    descriptionBox.setEditable(false);
    description.getChildren().add(descriptionBox);
    description.getChildren().add(this.link);
    day.getChildren().add(new Label(dayOfWeek.name()));
    this.addExtraDetails(extra);
  }

  /**
   * for adding extra details about a task/event
   *
   * @param extra a VBox
   */
  public abstract void addExtraDetails(VBox extra);

  /**
   * removes the task/event from the GUI
   *
   * @param vBox a VBox
   */
  public void removeInstances(VBox vBox) {
    vBox.getChildren().remove(this.infoButton);
  }

  /**
   * getter for this.link which was given by the user in the description
   *
   * @return a HyperLink
   */
  public Hyperlink getLink() {
    return this.link;
  }

  /**
   * getter for this.name
   *
   * @return a String
   */
  public String getName() {
    return this.name;
  }

  /**
   * getter for this.description
   *
   * @return a String
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * getter for this.dayOfWeek that the task takes place on
   *
   * @return Days
   */
  public Days getDayOfWeek() {
    return this.dayOfWeek;
  }
}
