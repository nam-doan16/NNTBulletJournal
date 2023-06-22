package cs3500.pa05.model.theme;

/**
 * abstract class for themes
 */
public class AbstTheme {
  protected String backgroundColor;
  protected String fontColor;
  protected String fontFamily;
  protected String name;

  public AbstTheme(String backgroundColor, String fontColor, String fontFamily) {
    this.backgroundColor = backgroundColor;
    this.fontColor = fontColor;
    this.fontFamily = fontFamily;
  }

  /**
   * getter for the backgroundColor
   *
   * @return this.backgroundColor
   */
  public String getBackgroundColor() {
    return this.backgroundColor;
  }

  /**
   * getter for fontColor
   *
   * @return this.fontColor
   */
  public String getFontColor() {
    return this.fontColor;
  }

  /**
   * getter for fontFamily
   *
   * @return this.fontFamily
   */
  public String getFontFamily() {
    return this.fontFamily;
  }

  public String getName() {
    return this.name;
  }
}
