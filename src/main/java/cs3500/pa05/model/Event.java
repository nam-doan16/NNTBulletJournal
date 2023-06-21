package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import cs3500.pa05.model.enums.TimeNotation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Event extends AbstTaskEvent {
  private String startTimeString;
  private int duration;
  private TimeNotation timeNotation;

  public Event(String name, String description,
               Days day, String startTimeString, TimeNotation timeNotation, int durationMin) {
    super(name, description, day);
    this.startTimeString = startTimeString;
    this.timeNotation = timeNotation;
    duration = durationMin;
    this.infoButton = new Button("Event: " + this.name);

  }

  @Override
  public Button getInfoButton() {
    return this.infoButton;
  }
  @Override
  public void addExtraDetails(VBox extra) {
    extra.getChildren().add(new Label("Start time: " + this.startTimeString + timeNotation));
    extra.getChildren().add(new Label("Duration: " + this.calculateDuration()));
  }

  private String calculateDuration() {
    return (duration >= 60) ? duration / 60 + " hours, " + duration % 60 + " minutes"
        : duration % 60 + " minutes";
  }

}
