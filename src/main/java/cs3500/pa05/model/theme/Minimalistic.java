package cs3500.pa05.model.theme;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * represents the minimalistic theme
 */
public class Minimalistic extends AbstTheme{

  /**
   * constructor sets:
   * background = white
   * font color = black
   * font = arial
   */
  public Minimalistic() {
    this.backgroundColor = Color.WHITE;
    this.fontColor = Color.BLACK;
    this.fontFamily = new Font("Arial", 12);
  }
}
