package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class AbstTaskEvent {
  protected String name;
  protected String description;
  protected Days dayOfWeek;

  public AbstTaskEvent(String name, String description, Days dayOfWeek) {
    this.name = name;
    this.description = description;
    this.dayOfWeek = dayOfWeek;
  }

  public abstract VBox getInfoBox();
  public abstract HBox getGenericInfoBox();
}
