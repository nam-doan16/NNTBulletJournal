package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import java.time.Duration;
import java.time.LocalTime;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Event extends AbstTaskEvent {
  private LocalTime startTime;
  private int duration;

  public Event(String name, String description,
               Days day, String startTimeString, String durationMin) {
    super(name, description, day);
    //startTime = LocalTime.parse(startTimeString);
    //duration = Duration.ofMinutes(durationMin);
  }


  @Override
  public Button getInfoButton() {
    return null;
  }

  @Override
  public void addExtraDetails(VBox extra) {

  }


}
