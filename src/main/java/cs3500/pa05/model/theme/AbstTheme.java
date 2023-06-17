package cs3500.pa05.model.theme;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * abstract class for themes
 */
public class AbstTheme {
  protected Color backgroundColor;
  protected Color fontColor;
  protected Font fontFamily;

  /**
   * getter for the backgroundColor
   *
   * @return this.backgroundColor
   */
  public Color getBackgroundColor() {
    return this.backgroundColor;
  }

  /**
   * getter for fontColor
   *
   * @return this.fontColor
   */
  public Color getFontColor() {
    return this.fontColor;
  }

  /**
   * getter for fontFamily
   *
   * @return this.fontFamily
   */
  public Font getFontFamily() {
    return this.fontFamily;
  }
}
