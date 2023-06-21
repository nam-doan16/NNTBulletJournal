package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TimeNotation;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * represents an Event which extends AbstTaskEvent
 */
public class Event extends AbstTaskEvent {
  private String startTimeString;
  private int duration;
  private TimeNotation timeNotation;

  /**
   * constructor
   *
   * @param name the name of the event
   * @param description the description for the event
   * @param day the day the event takes place on
   * @param startTimeString the start time of the event
   * @param timeNotation the notation for the start time
   * @param durationMin how long the event goes on for (given in minutes)
   * @param link a link given by the user in the description
   */
  public Event(String name, String description, Days day,
               String startTimeString, TimeNotation timeNotation, int durationMin, String link) {
    super(name, description, day, link);
    this.startTimeString = startTimeString;
    this.timeNotation = timeNotation;
    this.duration = durationMin;
    this.infoButton = new Button("Event: " + this.name);

  }

  /**
   * getter for this.infoButton
   *
   * @return a Button
   */
  @Override
  public Button getInfoButton() {
    return this.infoButton;
  }

  /**
   * adds the start time and duration of the event
   *
   * @param extra a VBox
   */
  @Override
  public void addExtraDetails(VBox extra) {
    extra.getChildren().add(new Label("Start time: " + this.startTimeString + timeNotation));
    extra.getChildren().add(new Label("Duration: " + this.calculateDuration()));
  }

  /**
   * calculates how long the event will go on for and puts it into hours, minutes format
   *
   * @return String
   */
  private String calculateDuration() {
    return (duration >= 60) ? duration / 60 + " hours, " + duration % 60 + " minutes"
        : duration % 60 + " minutes";
  }

  /**
   * getter for the this.startTimeString of the event
   *
   * @return a String
   */
  public String getStartTimeString() {
    return this.startTimeString;
  }

  /**
   * getter for the this.duration of the event
   *
   * @return an int
   */
  public int getDuration() {
    return this.duration;
  }

}
