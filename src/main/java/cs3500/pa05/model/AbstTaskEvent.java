package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstTaskEvent {
  protected String name;
  protected String description;
  protected Days dayOfWeek;

  public AbstTaskEvent(String name, String description, Days dayOfWeek) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
  }

  public abstract Button getInfoButton();
}
