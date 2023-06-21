package cs3500.pa05.model.theme;

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
    super("#c3ac78", "#000000", "Times New Roman");
    this.name = "vintage";
  }
}
