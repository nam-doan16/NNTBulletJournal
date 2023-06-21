package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

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

}