package cs3500.pa05.model.theme;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * represents the vintage theme
 */
public class Vintage extends AbstTheme {

  /**
   * constructor sets
   * background = beige
   * font color = black
   * font = Times New Roman
   */
  public Vintage() {
    this.backgroundColor = Color.BEIGE;
    this.fontColor = Color.BLACK;
    this.fontFamily = new Font("Times New Roman", 12);
  }
}
