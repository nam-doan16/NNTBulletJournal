package cs3500.pa05.model.theme;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * represents the minimalistic theme
 */
public class Minimalistic extends AbstTheme {

  /**
   * constructor sets:
   * background = white
   * font color = black
   * font = arial
   */
  public Minimalistic() {
    super("#ffffff", "#000000", "arial");
    this.name = "minimal";
  }
}
