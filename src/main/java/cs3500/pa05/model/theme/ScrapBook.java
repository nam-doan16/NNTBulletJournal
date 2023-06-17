package cs3500.pa05.model.theme;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * represents the scrapbook theme
 */
public class ScrapBook extends AbstTheme {

  /**
   * constructor sets
   * background = antique white/off white
   * font color = black
   * font = Comic Sans MS
   */
  public ScrapBook() {
    this.backgroundColor = Color.ANTIQUEWHITE;
    this.fontColor = Color.BLACK;
    this.fontFamily = new Font("Comic Sans MS", 12);
  }
}
