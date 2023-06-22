package cs3500.pa05.model.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test class for Days enumeration
 */
class DaysTest {
  /**
   * Test for Days values
   */
  @Test
  public void testValues() {
    Days[] values = Days.values();
    assertEquals(values.length, 7);
    assertEquals(values[0], Days.SUNDAY);
    assertEquals(values[1], Days.MONDAY);
    assertEquals(values[2], Days.TUESDAY);
    assertEquals(values[3], Days.WEDNESDAY);
    assertEquals(values[4], Days.THURSDAY);
    assertEquals(values[5], Days.FRIDAY);
    assertEquals(values[6], Days.SATURDAY);
  }

  /**
   * Test for Days valueOf
   */
  @Test
  public void testValueOf() {
    assertEquals(Days.valueOf("MONDAY"), Days.MONDAY);
    assertEquals(Days.valueOf("TUESDAY"), Days.TUESDAY);
    assertEquals(Days.valueOf("WEDNESDAY"), Days.WEDNESDAY);
    assertEquals(Days.valueOf("THURSDAY"), Days.THURSDAY);
    assertEquals(Days.valueOf("FRIDAY"), Days.FRIDAY);
    assertEquals(Days.valueOf("SATURDAY"), Days.SATURDAY);
    assertEquals(Days.valueOf("SUNDAY"), Days.SUNDAY);
  }
}