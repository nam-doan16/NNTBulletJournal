package cs3500.pa05.model;

import cs3500.pa05.model.enums.Days;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Task extends AbstTaskEvent {
  private boolean complete;
  public Task(String name, String description, Days dayOfWeek) {
    super(name, description, dayOfWeek);
  }
  @Override
  public VBox getInfoBox() {
    Label nameLabel = new Label(this.name);
    Label descriptionLabel = new Label(this.description);
    VBox vbox = new VBox(2, nameLabel, descriptionLabel);
    vbox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    return vbox;
  }

  @Override
  public HBox getGenericInfoBox() {
    return null;
  }
}
