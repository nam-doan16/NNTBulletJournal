package cs3500.pa05.model.theme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for AbstTheme and subclasses
 */
class ThemeTest {
  AbstTheme minimal;
  AbstTheme vintage;
  AbstTheme space;
  AbstTheme scrapBook;

  @BeforeEach
  public void setUp() {
    minimal = new Minimalistic();
    vintage = new Vintage();
    space = new Space();
    scrapBook = new ScrapBook();
  }

  /**
   * test for getBackgroundColor
   */
  @Test
  public void testGetBackgroundColor() {
    assertEquals(minimal.getBackgroundColor(), "#ffffff");
    assertEquals(vintage.getBackgroundColor(), "#c3ac78");
    assertEquals(space.getBackgroundColor(), "#000000");
    assertEquals(scrapBook.getBackgroundColor(), "#e1dbc1");
  }

  /**
   * test for getFontColor
   */
  @Test
  public void testGetFontColor() {
    assertEquals(minimal.getFontColor(), "#000000");
    assertEquals(vintage.getFontColor(), "#000000");
    assertEquals(space.getFontColor(), "#ffffff");
    assertEquals(scrapBook.getFontColor(), "#000000");
  }

  /**
   * test for getFontFamily
   */
  @Test
  public void testGetFontFamily() {
    assertEquals(minimal.getFontFamily(), "arial");
    assertEquals(vintage.getFontFamily(), "georgia");
    assertEquals(space.getFontFamily(), "impact");
    assertEquals(scrapBook.getFontFamily(), "verdana");
  }

  /**
   * test for getName
   */
  @Test
  public void testGetName() {
    assertEquals(minimal.getName(), "minimal");
    assertEquals(vintage.getName(), "vintage");
    assertEquals(space.getName(), "space");
    assertEquals(scrapBook.getName(), "scrapbook");
  }
}