package cs3500.pa05.model.theme;

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
    super("#e1dbc1", "#000000", "verdana");
    this.name = "scrapbook";
  }
}
