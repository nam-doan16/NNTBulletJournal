package cs3500.pa05.model.theme;

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
    super("#000000", "#ffffff", "impact");
    this.name = "space";
  }
}
