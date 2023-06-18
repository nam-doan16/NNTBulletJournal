package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import java.time.Duration;
import java.time.LocalTime;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Event extends AbstTaskEvent {
  private LocalTime startTime;
  private Duration duration;

  public Event(String name, String description, Days day, String startTimeString, int durationMin) {
    super(name, description, day);
    startTime = LocalTime.parse(startTimeString);
    duration = Duration.ofMinutes(durationMin);
  }

  @Override
  public VBox getInfoBox() {
    return null;
  }

  @Override
  public HBox getGenericInfoBox() {
    return null;
  }
}
