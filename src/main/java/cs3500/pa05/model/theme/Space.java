package cs3500.pa05.model.theme;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * represents the space theme
 */
public class Space extends AbstTheme {

  /**
   * constructor sets
   * background = black
   * font folor = white
   * font = Arial
   */
  public Space() {
    super("#000000", "#ffffff", "Source Code Pro");
    this.name = "space";
  }
}
