package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test class for ArgumentValidator
 */
class ArgumentValidatorTest {
  /**
   * Test for nonEmptyName
   */
  @Test
  public void testNonEmptyName() {
    // TEXTBOX ENTRIES WILL NEVER BE NULL!!!!
    assertEquals(ArgumentValidator.nonEmptyName("Hello"), "Hello");
    Exception e = assertThrows(IllegalArgumentException.class, () ->
        ArgumentValidator.nonEmptyName(""), "Invalid name.");
    assertEquals(e.getMessage(), "Invalid name.");
  }

  /**
   * Test for checkTimeFormat
   */
  @Test
  public void testCheckTimeFormat() {
    assertEquals(ArgumentValidator.checkTimeFormat("08:15"), "08:15");

    // testing empty string
    Exception e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat(""), "Cannot leave time empty!");
    assertEquals(e.getMessage(), "Cannot leave time empty!");

    // testing kind of valid time
    e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat("8:15"),
        "Incorrect time format! (e.g. 08:15)");
    assertEquals(e.getMessage(), "Incorrect time format! (e.g. 08:15)");

    // testing valid but not 2 numbers on each side of :
    e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat("8:151"),
        "Incorrect time format! (e.g. 08:15)");
    assertEquals(e.getMessage(), "Incorrect time format! (e.g. 08:15)");

    // testing invalid string
    e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat("asfdi"),
        "Incorrect time format! (e.g. 08:15)");
    assertEquals(e.getMessage(), "Incorrect time format! (e.g. 08:15)");
  }

  /**
   * Testing checkTimeFormat invalid time number branches
   */
  @Test
  public void testCheckTimeFormatNumberBranch() {
    Exception e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat("60:00"),
        "Incorrect time numbers");
    assertEquals(e.getMessage(), "Incorrect time numbers");

    e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat("00:70"),
        "Incorrect time numbers");
    assertEquals(e.getMessage(), "Incorrect time numbers");
    e = assertThrows(IllegalArgumentException.class,
        () -> ArgumentValidator.checkTimeFormat("90:40"),
        "Incorrect time numbers");
    assertEquals(e.getMessage(), "Incorrect time numbers");



  }

  /**
   * test for checkStringNumber
   */
  @Test
  public void testCheckStringNumber() {
    assertEquals(ArgumentValidator.checkStringPosNumber("50", "test"),
        50);

    Exception e = assertThrows(IllegalArgumentException.class, () ->
        ArgumentValidator.checkStringPosNumber("as1", "test"), "test");
    assertEquals(e.getMessage(), "test");

    e = assertThrows(IllegalArgumentException.class, () ->
        ArgumentValidator.checkStringPosNumber("-5", "test"),
        "Negative numbers not allowed");
    assertEquals(e.getMessage(), "Negative numbers not allowed");
  }

  /**
   * test for giveValidLink
   */
  @Test
  public void testGiveValidLink() {
    assertEquals(ArgumentValidator.giveValidLink(""), "");
    assertEquals(ArgumentValidator.giveValidLink("mynamesjeff"), "");
    assertEquals(
        ArgumentValidator.giveValidLink("https://www.hitc.com/en-gb/2021/11/24/my-name-jeff-meme/"),
        "https://www.hitc.com/en-gb/2021/11/24/my-name-jeff-meme/");
    assertEquals(ArgumentValidator.giveValidLink("asdfasdf "
        + "https://www.hitc.com/en-gb/2021/11/24/my-name-jeff-meme/"
        + " asdfasdfasdf"),
        "https://www.hitc.com/en-gb/2021/11/24/my-name-jeff-meme/");
    assertEquals(
        ArgumentValidator.giveValidLink("asdf http://www.columbia.edu/~fdc/sample.html"),
        "http://www.columbia.edu/~fdc/sample.html");
    String description = null;
    assertEquals(ArgumentValidator.giveValidLink(description), "");
  }
}