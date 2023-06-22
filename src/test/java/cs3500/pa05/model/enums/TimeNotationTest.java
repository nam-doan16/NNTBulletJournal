package cs3500.pa05.model.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * Test class for TimeNotation
 */
class TimeNotationTest {
  /**
   * Test for TimeNotation values
   */
  @Test
  public void testValues() {
    TimeNotation[] values = TimeNotation.values();
    assertEquals(values.length, 2);
    assertEquals(values[0], TimeNotation.AM);
    assertEquals(values[1], TimeNotation.PM);
  }

  /**
   * Test for TimeNotation valueOf
   */
  @Test
  public void testValueOf() {
    assertEquals(TimeNotation.valueOf("AM"), TimeNotation.AM);
    assertEquals(TimeNotation.valueOf("PM"), TimeNotation.PM);
  }
}